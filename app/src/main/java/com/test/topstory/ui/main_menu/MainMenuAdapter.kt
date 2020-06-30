package com.test.topstory.ui.main_menu

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.topstory.R
import com.test.topstory.models.Story
import com.test.topstory.ui.detail.DetailStoryActivity
import kotlinx.android.synthetic.main.list_items.view.*

class MainMenuAdapter(private val listStories: ArrayList<Story>)
    : RecyclerView.Adapter<MainMenuAdapter.MainMenuViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainMenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_items,parent,false)
        return MainMenuViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listStories.size
    }

    override fun onBindViewHolder(holder: MainMenuViewHolder, position: Int) {
        holder.bind(listStories[position])
    }

    class MainMenuViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item : Story) {
            with(itemView) {
                with(item) {
                    tv_title.text = title
                    tv_count_comments.text = "${kids?.size}"
                    tv_score.text = "$score"

                    itemView.setOnClickListener {
                        val intent = Intent(context, DetailStoryActivity::class.java)
                        intent.putExtra(DetailStoryActivity.titleDetail,title)
                        intent.putExtra(DetailStoryActivity.comments,"${kids?.size}")
                        intent.putExtra(DetailStoryActivity.userName,by)
                        intent.putExtra(DetailStoryActivity.score,"$score")
                        intent.putExtra(DetailStoryActivity.dateStory,time)
                        intent.putExtra(DetailStoryActivity.idStory,"$id")
                        context.startActivity(intent)
                    }
                }
            }
        }
    }
}