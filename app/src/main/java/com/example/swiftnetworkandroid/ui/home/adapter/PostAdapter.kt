package com.example.swiftnetworkandroid.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.swiftnetworkandroid.core.BaseViewHolder
import com.example.swiftnetworkandroid.data.model.Post
import com.example.swiftnetworkandroid.databinding.PostItemBinding
import com.squareup.picasso.Picasso

class PostAdapter(private val postList:List<Post>, private val onHomeClickListener: OnHomeClickListener): RecyclerView.Adapter<BaseViewHolder<*>>() {

    /**
     * Interface
     */
    interface OnHomeClickListener {
        fun onHeaderClick(post: Post)
    }

    /**
     * Create ViewHolder
     * Click elements
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding =
            PostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = PostViewHolder(itemBinding)
        itemBinding.root.setOnClickListener {
            val position = holder.bindingAdapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION }
                ?:return@setOnClickListener
            onHomeClickListener.onHeaderClick(postList[position])
        }
        return holder
    }

    /**
     * Return position
     * @param holder: PostHolder
     * @param position: Int
     */
    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder) {
            is PostViewHolder -> holder.bind(postList[position])
        }
    }

    /** Count items or post
     * Reference UITableView numberOfRowsInSection
     * @return post.size
     */
    override fun getItemCount(): Int = postList.size

    /**
     * Save data
     * @param view:View
     */
    private inner class PostViewHolder(private val binding: PostItemBinding): BaseViewHolder<Post>(binding.root) {
        private  val image          = binding.thumbnailImage
        private  var username       = binding.username
        private  var likeCount      = binding.likes
        private  var description    = binding.description
        private  var commentsCount  = binding.comments
        private  var publisher      = binding.publisher

        override fun bind(item: Post) {
            Picasso.get().load(item.post_image[0].image.src).into(image)
            username.text        = item.user_author.username
            likeCount.text       = item.likes.size.toString()
            description.text     = item.content
            commentsCount.text   = item.comments.size.toString()
            publisher.text       = "item.publisher"
        }
    }
}