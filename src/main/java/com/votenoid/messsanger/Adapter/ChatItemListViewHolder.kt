package com.votenoid.messsanger.Adapter

import android.content.Context
import android.view.View
import com.votenoid.votenoid.Adapter.MainViewHolder
import com.votenoid.votenoid.Adapter.SuperClickListener

class ChatItemListViewHolder(view:View) : MainViewHolder(view) {

    override fun bindPostType(
        types: SuperEntity,
        context: Context,
        clickListener: SuperClickListener
    ) {

        itemView.setOnClickListener {
            clickListener.onClickItem(adapterPosition)
        }



    }
}