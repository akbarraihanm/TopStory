package com.test.topstory.ui.main_menu

import com.test.topstory.models.Story

interface MainMenuContract {
    fun showDataListStories(listStories : ArrayList<Long>)
    fun showStory(story: Story)
    fun showLoading()
}