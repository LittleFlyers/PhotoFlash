package com.zpf.photoflash.upload.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.zpf.photoflash.common.base.BaseActivity
import com.zpf.photoflash.upload.R
import com.zpf.photoflash.upload.entity.ImgInfo


@Route(path = "/upload/PreviewImg")
class PreviewImgActivity : BaseActivity() {
    private val TAG = "PreviewImg"
    private lateinit var previewImgViewModel: PreviewImgViewModel
    private var mImgList: MutableList<ImgInfo> = ArrayList<ImgInfo>()

    override fun getViewContentId(): Int {
        return R.layout.activity_priview_img
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        initObserve()
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        if (requestCode == 0) {
            if (data != null) {
                val uri: Uri? = data.data
                Log.d(TAG, "onActivityResult: " + uri.toString())
                if (uri != null) {
                    previewImgViewModel.changePreImgUri(uri)
                }
                super.onActivityResult(requestCode, resultCode, data)
            }
        }
    }

    fun onclick(view: View) {
        val intent = Intent()
        intent.action = Intent.ACTION_PICK
        intent.type = "image/*"
        startActivityForResult(intent, 0)
    }

    private fun init() {
        ARouter.getInstance().inject(this)
        previewImgViewModel = ViewModelProvider(this).get(PreviewImgViewModel::class.java)
    }

    private fun initObserve() {
        previewImgViewModel.preImgUri.observe(this, Observer {
            freshPreImgView(it.uri)
        })
        previewImgViewModel.imgList.observe(this, Observer {
            initPhotoList(it)
        })
        previewImgViewModel.getImgList(this)
    }

    private fun freshPreImgView(uri: Uri) {
        val preImage = findViewById<ImageView>(R.id.img_upload_preview)
        preImage.setImageURI(uri)
    }

    private fun initPhotoList(data: MutableList<ImgInfo>) {
        freshPreImgView(data[0].uri)
    }
}