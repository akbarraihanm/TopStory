package com.test.topstory.ui.main_menu

import android.util.Log
import com.test.topstory.models.Story
import com.test.topstory.service.ApiClient
import com.test.topstory.service.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainMenuPresenter (private val mainMenuContract: MainMenuContract) {
    private val apiInterface = ApiClient.getApi().create(ApiInterface::class.java)

    fun getDataStories() {
        val call = apiInterface.getTopStories()
        call.enqueue(object : Callback<ArrayList<Long>> {
            override fun onFailure(call: Call<ArrayList<Long>>, t: Throwable) {
                Log.d("theFailure","$t")
            }

            override fun onResponse(
                call: Call<ArrayList<Long>>,
                response: Response<ArrayList<Long>>
            ) {
                val theList = response.body()
                try {
                    if (response.code() == 200) {
                        Log.d("responseBody","res : ${response.body()}")
                        theList?.let { mainMenuContract.showDataListStories(it) }
                    }
                } catch (e:Exception) {
                    Log.d("theException","$e")
                }
            }

        })
    }

    fun getStoryItem(story: Long) {
        val call = apiInterface.getStoryItem(story)
        call.enqueue(object : Callback<Story> {
            override fun onFailure(call: Call<Story>, t: Throwable) {
                Log.d("theFailure","$t")
            }

            override fun onResponse(call: Call<Story>, response: Response<Story>) {
                val theData = response.body()
                try {
                    if (response.code() == 200) {
                        Log.d("theStoryData","$theData")
                        theData?.let { mainMenuContract.showStory(it) }
                    }
                }catch (e:Exception) {
                    Log.d("theException","$e")
                }
            }

        })
    }
}