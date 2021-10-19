package com.votenoid.messsanger.MessagingScreens.StartUps

import android.app.Activity
import android.content.ContentValues.TAG
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.votenoid.messsanger.MessagingScreens.ClickListen
import com.votenoid.messsanger.R
import com.votenoid.messsanger.Util.AuthenticateUser
import java.util.concurrent.TimeUnit

class NumberScreen : Fragment() {
    private val hideHandler = Handler()

    lateinit var countryCode: EditText
    lateinit var number: EditText
    lateinit var numberButton: Button
    var storedVerificationId: String? = null
    lateinit var authUser: AuthenticateUser

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val contentView =
            LayoutInflater.from(context).inflate(R.layout.number_screen, container, false)
        numberButton = contentView.findViewById(R.id.numberButton)
        number = contentView.findViewById(R.id.number)
        countryCode = contentView.findViewById(R.id.countryCode)

        authUser = AuthenticateUser(activity as Activity, clickListen)

        numberButton.setOnClickListener {
            authUser.authenticate("+234 ${number.text.toString()}")
        }
        return contentView

    }

    fun numberAction(code:String) {
      /*  var action = NumberScreenDirections.actionNumberScreenToAuthentication(code)
        findNavController().navigate(action)

       */
    }

    var clickListen = object : ClickListen {
        override fun action(code: String) {
            if (code != null) {
                numberAction(code)
            }

        }
    }

}