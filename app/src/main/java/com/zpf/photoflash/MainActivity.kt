package com.zpf.photoflash

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.launcher.ARouter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.zpf.photofalsh.mine.MineFragment
import com.zpf.photoflash.common.base.BaseActivity
import com.zpf.photoflash.home.HomeFragment

class MainActivity : BaseActivity() {

    private lateinit var mNavView: BottomNavigationView
    private var mNavId: Int = R.id.navigation_home;
    override fun getViewContentId(): Int {
        return R.layout.activity_main
    }

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
        mNavView = findViewById(R.id.nav_view)
        mNavView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    mNavId = R.id.navigation_home
                    jumpFragment(HomeFragment())
                }
                R.id.navigation_upload -> {
                    ARouter.getInstance().build("/upload/PreviewImg").navigation()
                }
                R.id.navigation_notifications -> {
                    mNavId = R.id.navigation_notifications
                    jumpFragment(MineFragment())
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
        mNavView.selectedItemId = R.id.navigation_home
        mNavId = mNavView.selectedItemId
    }

    override fun onResume() {
        super.onResume()
        mNavView.selectedItemId = mNavId
    }

    private fun jumpFragment(fragment: Fragment) {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.nav_host_fragment, fragment).commitAllowingStateLoss()
    }
}