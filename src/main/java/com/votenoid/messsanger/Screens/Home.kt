package com.votenoid.messsanger.Screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.fragment.findNavController
import com.votenoid.messsanger.R

class Home : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        var view:View= inflater.inflate(R.layout.home, container, false)

        var button:Button=view.findViewById(R.id.move)


      /*  button.setOnClickListener {
            var action=HomeDirections.actionHome2ToOptionDialog()
            findNavController().navigate(action)
        }

       */
        return view
    }


}