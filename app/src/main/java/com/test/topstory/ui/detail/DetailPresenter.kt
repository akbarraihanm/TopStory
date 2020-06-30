package com.test.topstory.ui.detail

import android.util.Log
import com.test.topstory.models.Story
import com.test.topstory.service.ApiClient
import com.test.topstory.service.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailPresenter(private val detailContract: DetailContract) {
    private val apiInterface = ApiClient.getApi().create(ApiInterface::class.java)

    fun getComments(storyId : Long) {
        val call = apiInterface.getStoryItem(storyId)
        call.enqueue(object : Callback<Story> {
            override fun onFailure(call: Call<Story>, t: Throwable) {
                Log.d("theFailure","$t")
            }

            override fun onResponse(call: Call<Story>, response: Response<Story>) {
                val theComments = response.body()?.kids
                try {
                    if (response.code() == 200) {
                        theComments?.let { detailContract.showComments(it) }
                    }
                }catch (e:Exception) {
                    Log.d("theException","$e")
                }
            }

        })
    }

    fun getCommentData(id : Long) {
        val call = apiInterface.getStoryItem(id)
        call.enqueue(object : Callback<Story> {
            override fun onFailure(call: Call<Story>, t: Throwable) {
                Log.d("theFailure","$t")
            }

            override fun onResponse(call: Call<Story>, response: Response<Story>) {
                val theCommentData = response.body()?.text
                try {
                    if (response.code() == 200) {
                        theCommentData?.let { detailContract.showCommentData(it) }
                    }
                } catch (e:Exception) {
                    Log.d("theException","$e")
                }
            }

        })
    }
}