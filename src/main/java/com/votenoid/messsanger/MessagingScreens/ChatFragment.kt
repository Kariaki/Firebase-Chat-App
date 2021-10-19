package com.votenoid.messsanger.MessagingScreens

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.votenoid.messsanger.Adapter.ChatItemListViewHolder
import com.votenoid.messsanger.Adapter.SuperEntity
import com.votenoid.messsanger.R
import com.votenoid.votenoid.Adapter.GeneralAdapter
import com.votenoid.votenoid.Adapter.MainViewHolder
import com.votenoid.votenoid.Adapter.SuperClickListener

class ChatFragment : Fragment() {


    lateinit var chatItemList: RecyclerView
    lateinit var adapter: GeneralAdapter

    var itemList = mutableListOf<SuperEntity>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val contentView = inflater.inflate(R.layout.chat, container, false)
        chatItemList = contentView.findViewById(R.id.chatItemList)
        populate()

        adapter = GeneralAdapter().apply {
            items = itemList
            superClickListener = superclick
            this.viewHolderPlug = viewHolderPlugs
        }

        chatItemList.layoutManager = LinearLayoutManager(context)
        chatItemList.hasFixedSize()
        chatItemList.adapter = adapter


        return contentView
    }

    fun populate() {
        itemList.add(SuperEntity())
        itemList.add(SuperEntity())
        itemList.add(SuperEntity())
        itemList.add(SuperEntity())
        itemList.add(SuperEntity())
        itemList.add(SuperEntity())
    }

    val viewHolderPlugs = object : GeneralAdapter.ViewHolderPlug {
        override fun setPlug(group: ViewGroup, viewType: Int): MainViewHolder {
            var contentView =
                LayoutInflater.from(context).inflate(R.layout.chat_list_item, group, false)
            return ChatItemListViewHolder(contentView)
        }


    }

    var superclick = object : SuperClickListener {
        override fun onClickItem(position: Int) {

            var intent: Intent = Intent(activity, MessagePage::class.java).apply {

            }
            startActivity(intent)
        }
    }

}