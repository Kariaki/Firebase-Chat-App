package com.votenoid.messsanger.MessagingScreens.StartUps

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.navArgs
import com.google.firebase.database.FirebaseDatabase
import com.votenoid.messsanger.MainActivity
import com.votenoid.messsanger.MessagingScreens.MessagingActivity
import com.votenoid.messsanger.R

class AboutUserFagment : Fragment() {

    val args: AboutUserFagmentArgs by navArgs()

    var users = FirebaseDatabase.getInstance().getReference("users")
    lateinit var aboutUser: EditText
    lateinit var next: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var contentView = inflater.inflate(R.layout.about_user_fagment, container, false)
        aboutUser = contentView.findViewById(R.id.aboutUser)
        next = contentView.findViewById(R.id.next)

        next.setOnClickListener {
            users.child(args.userId).child("aboutUser")
                .setValue(aboutUser.text.toString())
                .addOnSuccessListener {

                    var intent=Intent(activity,MessagingActivity::class.java)
                    startActivity(intent)
                }

        }

        return contentView
    }

}