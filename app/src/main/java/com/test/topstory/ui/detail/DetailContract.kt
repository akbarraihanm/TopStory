package com.test.topstory.ui.detail

interface DetailContract {
    fun showComments(listComments : ArrayList<Long>)
    fun showCommentData(text : String)
}