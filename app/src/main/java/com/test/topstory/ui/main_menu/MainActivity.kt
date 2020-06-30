package com.test.topstory.ui.main_menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.recyclerview.widget.GridLayoutManager
import com.test.topstory.R
import com.test.topstory.models.Story
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainMenuContract {

    private lateinit var mainMenuPresenter: MainMenuPresenter
    private lateinit var listStories : ArrayList<Story>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listStories = arrayListOf()
        mainMenuPresenter = MainMenuPresenter(this)
        rv_items.layoutManager = GridLayoutManager(this,2)
        mainMenuPresenter.getDataStories()
        showLoading()
    }

    override fun showDataListStories(listStories: ArrayList<Long>) {
        for(i in 0..20) {
            mainMenuPresenter.getStoryItem(listStories[i])
        }
    }

    override fun showStory(story: Story) {
        listStories.add(story)
        if (listStories.size == 20) {
            loading_items.visibility = INVISIBLE
            rv_items.adapter = MainMenuAdapter(listStories)
        }
    }

    override fun showLoading() {
        rv_items.adapter = null
        loading_items.visibility = VISIBLE
    }
}
