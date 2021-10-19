package com.votenoid.messsanger.MessagingScreens.StartUps

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.votenoid.messsanger.R

class Authentication : Fragment() {


    lateinit var authenticationButton: Button
    lateinit var number:String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val contentView = inflater.inflate(R.layout.authentication, container, false)
        authenticationButton = contentView.findViewById(R.id.authenticationButton)
        var intent=activity?.intent
        var userNumber=intent?.getStringExtra("number")
        number=userNumber!!


        authenticationButton.setOnClickListener {
            authenticationAction()
        }

        return contentView
    }

    fun authenticationAction() {
        var action = AuthenticationDirections.actionAuthenticationToCreateAccount(number)
        findNavController().navigate(action)


    }

}