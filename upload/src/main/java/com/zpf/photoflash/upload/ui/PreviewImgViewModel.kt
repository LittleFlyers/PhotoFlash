package com.zpf.photoflash.upload.ui

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zpf.photoflash.upload.entity.ImgInfo
import com.zpf.photoflash.upload.model.PhotoModel

class PreviewImgViewModel : ViewModel() {
    private val TAG = "PreviewImgViewModel"
    private val _imgUri = MutableLiveData<ImgInfo>()
    private val _imgList = MutableLiveData<MutableList<ImgInfo>>()

    val preImgUri: LiveData<ImgInfo> = _imgUri
    val imgList: LiveData<MutableList<ImgInfo>> = _imgList

    fun changePreImgUri(uri: Uri) {
        _imgUri.value = ImgInfo(uri)
    }

    fun getImgList(context: Context) {
        val photoModel = PhotoModel()
        _imgList.value = photoModel.getImageContentUri(context)
    }
}