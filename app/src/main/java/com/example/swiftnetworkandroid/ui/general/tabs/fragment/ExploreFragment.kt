package com.example.swiftnetworkandroid.ui.general.tabs.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.swiftnetworkandroid.R

class ExploreFragment : Fragment(R.layout.fragment_explore) {
    // TODO: onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupView()
    }

    private fun setupView() {

    }

}

/*

class SearchFragment : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var recyclerView: RecyclerView
    lateinit var search_bar: EditText

    // TODO: User  lateinit var list: List<User>
    var user: List<User> = listOf(
        User(id="0", username="eddylujann", fullname="lujan", imageurl="https://industriamusical.es/wp-content/uploads/2013/08/Android1.jpg", bio=""),
        User(id="1", username="jordan", fullname="lujan", imageurl="https://industriamusical.es/wp-content/uploads/2013/08/Android1.jpg", bio=""),
        User(id="2", username="lucas", fullname="Chinchay", imageurl="https://industriamusical.es/wp-content/uploads/2013/08/Android1.jpg", bio="")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_search, container, false)

        var view = inflater.inflate(R.layout.fragment_search, container, false)
        recyclerView =  view.findViewById(R.id.recyclerSearch_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = UserAdapter(user)
        search_bar = view.findViewById(R.id.search_bar)
        return view
    }
}

 */