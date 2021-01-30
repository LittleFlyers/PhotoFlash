package com.zpf.photoflash

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {
        //初始化ARouter
        //开debug模式，否则要开混淆
        ARouter.openDebug()
        ARouter.openLog()
        ARouter.init(this)
    }

}