package com.votenoid.votenoid.Adapter

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.votenoid.messsanger.Adapter.SuperEntity

abstract class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
     
     abstract fun  bindPostType(types: SuperEntity, context:Context, clickListener: SuperClickListener)


}