package com.example.swiftnetworkandroid.ui.tabs.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.swiftnetworkandroid.R
import com.example.swiftnetworkandroid.models.User
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class UserAdapter(var user:List<User>): RecyclerView.Adapter<UserAdapter.UserHolder>() {

    /** Create ViewHolder **/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val layoutInfalter = LayoutInflater.from(parent.context)
        return UserHolder(layoutInfalter.inflate(R.layout.user_item, parent, false))
    }

    /**
     ** Este metodo le dirá al RecyclerView cuantos Items o user tiene.
     ** return 2 (Esto seria como en Swift - UITableView - numberOfRowsInSection)
     **/
    override fun getItemCount(): Int = user.size

    /** Return position new **/
    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.render(user[position])
    }

    class UserHolder(val view: View): RecyclerView.ViewHolder(view) {
        lateinit var username: TextView
        lateinit var fullname: TextView
        lateinit var imageProfile: CircleImageView
        lateinit var btnFollow: Button

        fun render(user: User) {
            username = view.findViewById(R.id.username)
            fullname = view.findViewById(R.id.fullname)
            imageProfile = view.findViewById(R.id.image_profile)
            btnFollow = view.findViewById(R.id.btn_follow)

            //Add content in etiquetas
            username.text = user.username
            fullname.text = user.fullname
            Picasso.get()
                .load(user.imageurl)
                .into(imageProfile)

        }
    }
}