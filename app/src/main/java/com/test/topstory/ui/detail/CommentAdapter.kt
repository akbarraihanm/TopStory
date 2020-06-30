package com.test.topstory.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.topstory.R
import kotlinx.android.synthetic.main.list_comments.view.*

class CommentAdapter(private val listTexts: ArrayList<String>)
    : RecyclerView.Adapter<CommentAdapter.CommentViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_comments,parent,false)
        return CommentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listTexts.size
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.bind(listTexts[position])
    }

    class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(text : String) {
            with(itemView) {
                tv_comment.text = text
            }
        }
    }
}