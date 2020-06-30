package com.test.topstory.models

import com.google.gson.annotations.SerializedName

data class Story(
    @SerializedName("by")
    var by : String? = null,
    @SerializedName("descendants")
    var descendants : Int? = 0,
    @SerializedName("kids")
    val kids : ArrayList<Long>? = null,
    @SerializedName("score")
    var score : Int? = 0,
    @SerializedName("title")
    var title : String? = null,
    @SerializedName("time")
    var time : String? = null,
    @SerializedName("id")
    var id : Long? = 0,
    @SerializedName("text")
    var text : String? = null
)