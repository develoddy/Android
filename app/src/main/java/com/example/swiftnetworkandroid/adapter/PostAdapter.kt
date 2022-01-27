 package com.example.swiftnetworkandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.swiftnetworkandroid.R
import com.example.swiftnetworkandroid.models.Post
import com.squareup.picasso.Picasso

 class PostAdapter(val post:List<Post>): RecyclerView.Adapter<PostAdapter.PostHolder>() {

    /** Crea el ViewHolder **/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val layoutInfalter = LayoutInflater.from(parent.context)
        return PostHolder(layoutInfalter.inflate(R.layout.post_item, parent,false))
    }
    /**
    // Este metodo le dirá al RecyclerView cuantos Items o posts tiene
    // return 2 (Esto seria como en Swift - UITableView - numberOfRowsInSection)
    **/
    override fun getItemCount(): Int = post.size

    /** Devuelve una posicion nueva **/
    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        holder.render(post[position])
    }


    class PostHolder(val view: View):RecyclerView.ViewHolder(view) {
        //lateinit var postid: TextView
        lateinit var image: ImageView
        lateinit var username: TextView
        lateinit var likeCount: TextView
        lateinit var description: TextView
        lateinit var commentsCount: TextView
        lateinit var publisher: TextView

        fun render(post: Post) {
            //postid = view.findViewById(R.id)
            username = view.findViewById(R.id.username)
            image = view.findViewById(R.id.thumbnailImage)
            likeCount = view.findViewById(R.id.likes)
            description = view.findViewById(R.id.description)
            commentsCount = view.findViewById(R.id.comments)
            publisher = view.findViewById(R.id.publisher)

            //thumbnailImage android:src="@mipmap/ic_launcher"
            Picasso.get()
                .load(post.thumbnailImage)
                .into(image)
            username.text = post.username
            likeCount.text = post.likeCount
            description.text = post.description
            commentsCount.text = post.commentsCount
            publisher.text = post.publisher
        }
    }
}