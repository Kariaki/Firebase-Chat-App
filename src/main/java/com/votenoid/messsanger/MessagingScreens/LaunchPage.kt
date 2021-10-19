package com.votenoid.messsanger.MessagingScreens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.votenoid.messsanger.R

class LaunchPage : AppCompatActivity() {

    lateinit var handler: Handler

    private val RC_SIGN_IN = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch_page)
        handler = Handler()

        startRegistrationProcess()

    }


    private fun startRegistrationProcess() {
        val providers = listOf(
            AuthUI.IdpConfig.PhoneBuilder().build()
        )
        // providers.add(new AuthUI.IdpConfig.PhoneBuilder().build());
        startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setIsSmartLockEnabled(false) //.setTheme(R.style.Theme_AppCompat_Light_NoActionBar)
                .setAvailableProviders(providers)
                .build(),
            RC_SIGN_IN
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                val user = FirebaseAuth.getInstance().currentUser
                val intent = Intent(this, StartUpNavHost::class.java)
                assert(user != null)
                intent.putExtra("number", user!!.phoneNumber)
                startActivity(intent)


            }
        }
    }
}