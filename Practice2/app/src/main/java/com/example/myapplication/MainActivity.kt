package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter
    private var posts: MutableList<Post> = mutableListOf()

    companion object {
        private const val POSTS_STATE_KEY = "posts_state"
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate started")

        setContentView(R.layout.activity_main)
        Log.d(TAG, "setContentView completed")

        initViews()
        Log.d(TAG, "initViews completed")

        setupRecyclerView()
        Log.d(TAG, "setupRecyclerView completed")

        loadData(savedInstanceState)
        Log.d(TAG, "loadData completed")
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        Log.d(TAG, "RecyclerView found: ${recyclerView != null}")
    }

    private fun setupRecyclerView() {
        postAdapter = PostAdapter(mutableListOf()) { post ->
            handleLikeClick(post)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = postAdapter
        Log.d(TAG, "RecyclerView setup completed")
    }

    private fun loadData(savedInstanceState: Bundle?) {
        posts.clear()
        val mockPosts = MockData.getPosts()
        Log.d(TAG, "MockData returned ${mockPosts.size} posts")

        for (post in mockPosts) {
            posts.add(post)
            Log.d(TAG, "Added post: ${post.title}")
        }

        Log.d(TAG, "Posts list size after adding: ${posts.size}")
        postAdapter.updatePosts(posts)
        Log.d(TAG, "Final loaded ${posts.size} posts")
    }

    private fun handleLikeClick(post: Post) {
        val index = posts.indexOfFirst { it.id == post.id }
        if (index != -1) {
            val updatedPost = posts[index]
            if (updatedPost.isLiked) {
                updatedPost.isLiked = false
                updatedPost.likeCount = maxOf(0, updatedPost.likeCount - 1)
            } else {
                updatedPost.isLiked = true
                updatedPost.likeCount += 1
            }
            posts[index] = updatedPost
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList(POSTS_STATE_KEY, ArrayList(posts))
    }
}