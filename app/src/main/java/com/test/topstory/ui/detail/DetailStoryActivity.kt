package com.test.topstory.ui.detail

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.topstory.R
import kotlinx.android.synthetic.main.activity_detail_story.*
import java.text.SimpleDateFormat
import java.util.*

class DetailStoryActivity : AppCompatActivity(), DetailContract {

    companion object {
        var titleDetail = "TITLE"
        var userName = "USERNAME"
        var dateStory = "DATESTORY"
        var comments = "COMMENTS"
        var score = "SCORE"
        var idStory = "IDSTORY"
    }

    private lateinit var detailPresenter: DetailPresenter
    private lateinit var listTexts: ArrayList<String>
    private lateinit var countComment :ArrayList<Long>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_story)
        supportActionBar?.title = "Story Detail"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        listTexts = arrayListOf()
        countComment = arrayListOf()
        getStringData()

        detailPresenter = DetailPresenter(this)
        detailPresenter.getComments(idStory.toLong())

        rv_comments.layoutManager = LinearLayoutManager(this)

        deployData()
    }

    private fun getStringData() {
        titleDetail = intent.getStringExtra(titleDetail) ?: "TITLE"
        userName = intent.getStringExtra(userName) ?: "USERNAME"
        dateStory = intent.getStringExtra(dateStory) ?: "DATESTORY"
        comments = intent.getStringExtra(comments) ?: "0"
        score = intent.getStringExtra(score) ?: "0"
        idStory = intent.getStringExtra(idStory) ?: "ASDASD"
    }

    private fun deployData() {
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val dateFormat = Date(dateStory.toLong()*1000L)
        tv_detail_title.text = titleDetail
        tv_username.text = userName
        tv_date.text = sdf.format(dateFormat)
        tv_detail_comments.text = comments
        tv_detail_score.text = score
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            android.R.id.home -> {
                finish()
                true
            } else -> super.onOptionsItemSelected(item)
        }
    }

    override fun showComments(listComments: ArrayList<Long>) {
        countComment = listComments
        for (i in listComments.indices) {
            detailPresenter.getCommentData(listComments[i])
        }
    }

    override fun showCommentData(text: String) {
        listTexts.add(text)
        rv_comments.adapter = CommentAdapter(listTexts)
    }
}
