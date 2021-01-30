package com.zpf.photoflash.upload.ui

import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zpf.photoflash.upload.entity.ImgInfo

class PreviewImgViewModel : ViewModel() {
    private val TAG = "PreviewImgViewModel"
    private val _imgUri = MutableLiveData<ImgInfo>()

    val preImgUri: LiveData<ImgInfo> = _imgUri

    fun changePreImgUri(uri: Uri) {
        _imgUri.value = ImgInfo(uri)
    }
}