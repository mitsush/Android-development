package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class PostAdapter(
    private var posts: MutableList<Post>,
    private val onLikeClick: (Post) -> Unit
) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvContent: TextView = itemView.findViewById(R.id.tvContent)
        val ivPostImage: ImageView = itemView.findViewById(R.id.ivPostImage)
        val btnLike: ImageButton = itemView.findViewById(R.id.btnLike)
        val tvLikeCount: TextView = itemView.findViewById(R.id.tvLikeCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        try {
            if (position >= posts.size) return

            val post = posts[position]

            holder.tvTitle.text = post.title
            holder.tvContent.text = post.content

            Glide.with(holder.itemView.context)
                .load(post.imageUrl)
                .placeholder(android.R.drawable.ic_menu_gallery)
                .error(android.R.drawable.ic_menu_close_clear_cancel)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(holder.ivPostImage)

            updateLikeButton(holder, post)
            updateLikeCount(holder, post)

            holder.btnLike.setOnClickListener {
                onLikeClick(post)
                updateLikeButton(holder, post)
                updateLikeCount(holder, post)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun updateLikeButton(holder: PostViewHolder, post: Post) {
        if (post.isLiked) {
            holder.btnLike.setImageResource(android.R.drawable.btn_star_big_on)
        } else {
            holder.btnLike.setImageResource(android.R.drawable.btn_star_big_off)
        }
    }

    private fun updateLikeCount(holder: PostViewHolder, post: Post) {
        val likeText = when (post.likeCount) {
            0 -> "No likes"
            1 -> "1 like"
            else -> "${post.likeCount} likes"
        }
        holder.tvLikeCount.text = likeText
    }

    override fun getItemCount(): Int = posts.size

    fun updatePosts(newPosts: List<Post>) {
        posts.clear()
        posts.addAll(newPosts)
        notifyDataSetChanged()
        android.util.Log.d("PostAdapter", "updatePosts: received ${newPosts.size} posts, adapter now has ${posts.size} posts")
    }

    fun getPosts(): List<Post> = posts.toList()
}