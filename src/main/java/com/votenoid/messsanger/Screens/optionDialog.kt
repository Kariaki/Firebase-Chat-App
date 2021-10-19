package com.votenoid.messsanger.Screens

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.votenoid.messsanger.R

class optionDialog():BottomSheetDialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var contentView:View=LayoutInflater.from(context).inflate(R.layout.option_dialog,container,false)

        return contentView
    }

}