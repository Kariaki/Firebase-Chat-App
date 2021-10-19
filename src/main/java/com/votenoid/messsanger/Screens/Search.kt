package com.votenoid.messsanger.Screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.votenoid.messsanger.R

class Search : Fragment() {

    private val args : SearchArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var contentView:View= inflater.inflate(R.layout.search, container, false)

        var text:TextView=contentView.findViewById(R.id.text)
        text.text=args.name

        return contentView
    }

}