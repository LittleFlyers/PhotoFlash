package com.zpf.photoflash.upload.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.zpf.photoflash.common.base.BaseActivity
import com.zpf.photoflash.upload.R

@Route(path = "/upload/PreviewImg")
class PreviewImgActivity : BaseActivity() {
    override fun getViewContentId(): Int {
        return R.layout.activity_priview_img
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
    }
}