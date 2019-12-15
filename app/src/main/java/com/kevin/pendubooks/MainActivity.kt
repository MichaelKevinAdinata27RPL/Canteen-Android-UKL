package com.kevin.pendubooks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewpager_main.adapter = FragmentAdapter(supportFragmentManager)
        tabs_main.setupWithViewPager(viewpager_main)
        tabs_main.getTabAt(0)!!.setIcon(R.drawable.ic_action_home)
        tabs_main.getTabAt(1)!!.setIcon(R.drawable.ic_action_tambah)
    }
}
