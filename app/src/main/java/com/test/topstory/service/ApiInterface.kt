package com.test.topstory.service

import com.test.topstory.models.Story
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("topstories.json?print=pretty")
    fun getTopStories() : Call<ArrayList<Long>>

    @GET("item/{story}.json?print=pretty")
    fun getStoryItem(@Path("story") story: Long) : Call<Story>
}