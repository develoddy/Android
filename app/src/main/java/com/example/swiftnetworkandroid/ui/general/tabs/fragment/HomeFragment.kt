package com.example.swiftnetworkandroid.ui.general.tabs.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.swiftnetworkandroid.R
import com.example.swiftnetworkandroid.adapter.PostAdapter
import com.example.swiftnetworkandroid.models.Post

// TODO: Fragment
class HomeFragment : Fragment(R.layout.fragment_home) {

    lateinit var recyclerView: RecyclerView

    var post: List<Post> = listOf(
        Post(postid="1",
            username="eddy",
            thumbnailImage="https://industriamusical.es/wp-content/uploads/2013/08/Android1.jpg",
            likeCount="10 Likes",
            description="Primera descripcion",
            commentsCount="Ver más comentarios",
            publisher="eddylujann"),

        Post(postid="1",
            username="jordan",
            thumbnailImage="https://industriamusical.es/wp-content/uploads/2013/08/Android1.jpg",
            likeCount="50 Likes",
            description="Segunda descripcion",
            commentsCount="Ver más comentarios",
            publisher="jordan")
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecycler(view)
    }

    private  fun initRecycler(view: View) {
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager( view.context )
        val adapter = PostAdapter(post)
        recyclerView.adapter = adapter
    }
}