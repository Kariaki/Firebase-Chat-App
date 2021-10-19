package com.votenoid.messsanger.MessagingScreens

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.AuthUI.IdpConfig
import com.firebase.ui.auth.AuthUI.IdpConfig.PhoneBuilder
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.votenoid.messsanger.R

class StartUpNavHost : AppCompatActivity() {


    private val RC_SIGN_IN = 0
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_up_nav_host)


        var navHost = supportFragmentManager.findFragmentById(R.id.navController) as NavHostFragment
        navController = navHost.findNavController()

        startRegistrationProcess()


    }


    private fun startRegistrationProcess() {
        val providers = listOf(
            PhoneBuilder().build()
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
                /*val intent = Intent(this, RegistrationHost::class.java)
                assert(user != null)
                intent.putExtra("phone number", user!!.phoneNumber)
                startActivity(intent)

                 */
            }
        }
    }
}