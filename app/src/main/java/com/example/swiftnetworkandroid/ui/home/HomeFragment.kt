package com.example.swiftnetworkandroid.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.swiftnetworkandroid.R
import com.example.swiftnetworkandroid.core.Resource
import com.example.swiftnetworkandroid.core.SessionManager
import com.example.swiftnetworkandroid.data.model.Post
import com.example.swiftnetworkandroid.data.remote.home.HomeDataSource
import com.example.swiftnetworkandroid.databinding.FragmentHomeBinding
import com.example.swiftnetworkandroid.repository.home.HomeRepositoryImpl
import com.example.swiftnetworkandroid.ui.home.adapter.PostAdapter
import com.example.swiftnetworkandroid.webservice.RetrofitClient
import com.example.swiftnetworkandroid.presentation.HomeViewModel
import com.example.swiftnetworkandroid.presentation.HomeViewModelFactory


// TODO: Fragment
class HomeFragment: Fragment(R.layout.fragment_home), PostAdapter.OnHomeClickListener {

    // Properties
    private lateinit var sessionManager: SessionManager
    private lateinit var binding: FragmentHomeBinding
    private lateinit var recyclerView: RecyclerView

    private val viewModel by viewModels<HomeViewModel>{
        HomeViewModelFactory(
            HomeRepositoryImpl(
                HomeDataSource(RetrofitClient.webservice)
            )
        )
    }

    /**
     * Set a new adapter to provide child views on demand.
     * When adapter is changed, all existing views are recycled back to the pool. If the pool has
     * only one adapter, it will be cleared.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().run {
            sessionManager = SessionManager(this)
        }

        viewModel.fetchUserPost("Bearer ${sessionManager.fetchAuthToken()}").observe(viewLifecycleOwner, Observer { result ->
            when(result) {
                is Resource.Loading -> {
                    Log.d("HomeFragmentLiveDataLoa", "Loading...")
                }
                is Resource.Success -> {
                    Log.d("HomeFragmentLiveDataSuc", "${result.data}")
                    binding = FragmentHomeBinding.bind(view)
                    recyclerView = binding.recyclerView
                    recyclerView.layoutManager = LinearLayoutManager(view.context)
                    val adapter = PostAdapter(result.data.userpost, this@HomeFragment)
                    recyclerView.adapter = adapter
                }
                is Resource.Failure -> {
                    Log.d("HomeFragmentLiveDataFai", "${result.exception}")
                }
            }
        })

    }

    // Click to Post.
    override fun onHeaderClick(post: Post) {
        Log.d("post", "onPostClick: $post")
    }
}