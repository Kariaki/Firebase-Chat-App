package com.votenoid.messsanger.MessagingScreens

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TableLayout
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.votenoid.messsanger.R
import com.votenoid.votenoid.Adapter.PageAdapter

class MessagingActivity : AppCompatActivity() {

    lateinit var pages: ViewPager2
    lateinit var pageAdapter: PageAdapter
    var fragmentPages=ArrayList<Fragment>()
    lateinit var bottom_nav:BottomNavigationView
    lateinit var tablayout:TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messaging)

        pages=findViewById(R.id.viewPager)
        bottom_nav=findViewById(R.id.botton_nav)
        pageAdapter=PageAdapter(this)
        tablayout=findViewById(R.id.tabLayout)

        pages.isUserInputEnabled=false
        bottom_nav.setOnItemSelectedListener (itemSelected)

        var mediator= TabLayoutMediator(tablayout,pages, object : TabLayoutMediator.TabConfigurationStrategy {
            override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                when(position){
                    0->
                        tab.icon=resources.getDrawable(R.drawable.chat2)

                    1-> tab.icon= getDrawable(R.drawable.person)
                    2-> tab.icon= getDrawable(R.drawable.settings)
                }
            }

        })
        fragmentPages.add(ChatFragment())
        fragmentPages.add(ProfileFragment())
        fragmentPages.add(SettingsFragment())
        pageAdapter.fragmentList=fragmentPages
        pages.adapter=pageAdapter

        mediator.attach()






    }
    val itemSelected= object : NavigationBarView.OnItemSelectedListener {
        override fun onNavigationItemSelected(item: MenuItem): Boolean {

            when (item.itemId){
                R.id.chat->
                    pages.currentItem=0
                R.id.profile->
                    pages.currentItem=1
                R.id.settings->
                    pages.currentItem=2
                else ->
                    pages.currentItem=0
            }
            return true
        }

    }


}