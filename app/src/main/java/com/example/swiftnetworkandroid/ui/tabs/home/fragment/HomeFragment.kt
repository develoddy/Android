package com.example.swiftnetworkandroid.ui.tabs.home.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.swiftnetworkandroid.R
import com.example.swiftnetworkandroid.ui.tabs.home.adapter.PostAdapter
import com.example.swiftnetworkandroid.models.Post

// TODO: Fragment
class HomeFragment : Fragment(R.layout.fragment_home) {

    lateinit var recyclerView: RecyclerView

    var post: List<Post> = listOf(
        Post(
            postid = "1",
            username = "eddy",
            thumbnailImage = "https://industriamusical.es/wp-content/uploads/2013/08/Android1.jpg",
            likeCount = "10 Likes",
            description = "Primera descripcion",
            commentsCount = "Ver más comentarios",
            publisher = "eddylujann"
        ),

        Post(
            postid = "1",
            username = "jordan",
            thumbnailImage = "https://industriamusical.es/wp-content/uploads/2013/08/Android1.jpg",
            likeCount = "50 Likes",
            description = "Segunda descripcion",
            commentsCount = "Ver más comentarios",
            publisher = "jordan"
        )
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler(view)

        /*
        val postHeader = view.findViewById<LinearLayout>(R.id.postHeader)
        postHeader.setOnClickListener {
            println("click header!!!!!.......")
        }
        */

    }

    /**
     * Set a new adapter to provide child views on demand.
     * <p>
     * When adapter is changed, all existing views are recycled back to the pool. If the pool has
     * only one adapter, it will be cleared.
     *
     * @param adapter The new adapter to set, or null to set no adapter.
     * @see #swapAdapter(Adapter, boolean)
     */
    private  fun initRecycler(view: View) {
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        val adapter = PostAdapter(post)
        recyclerView.adapter = adapter
    }
}