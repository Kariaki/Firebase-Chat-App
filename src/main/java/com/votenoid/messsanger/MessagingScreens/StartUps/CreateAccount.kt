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
import com.votenoid.messsanger.Database.Entities.user
import com.votenoid.messsanger.MessagingScreens.MessagingActivity
import com.votenoid.messsanger.R
import com.votenoid.messsanger.Screens.SearchArgs
import com.votenoid.messsanger.User

class CreateAccount : Fragment() {

    lateinit var createAccountButton: Button

    lateinit var username: EditText
    var enteredUsername: String? = null

    private val args: CreateAccountArgs by navArgs()
    var users = FirebaseDatabase.getInstance().getReference("users")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val contentView = inflater.inflate(R.layout.create_account, container, false)
        createAccountButton = contentView.findViewById(R.id.createAccountButton)
        username = contentView.findViewById(R.id.username)
        enteredUsername = username.text.toString()
        createAccountButton.setOnClickListener {
            var createdUser = createUser()
            createAccountAction(createdUser.userId)
        }

        return contentView
    }

    fun createUser(): user {
        var userkey = users.push().key!!
        var user = user(
            userkey, "",
            username = username.text.toString(),
            phoneNumber = args.number,
            profileUrl = ""

        )
        users.child(userkey).setValue(user)

        return user
    }

    fun createAccountAction(id: String) {
        var action = CreateAccountDirections.actionCreateAccountToAboutUserFagment(id)
        /*  var intent = Intent(activity, MessagingActivity::class.java)
              .apply {
                  flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
              }
          startActivity(intent)

         */
    }
}