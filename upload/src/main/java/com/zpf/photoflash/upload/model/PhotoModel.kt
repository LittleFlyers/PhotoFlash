package com.zpf.photoflash.upload.model

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import com.zpf.photoflash.upload.entity.ImgInfo
import com.zpf.photoflash.upload.utils.FileUtils

class PhotoModel {
    val TAG = "PhotoModel"
    @SuppressLint("Recycle")
    fun getImageContentUri(context: Context): MutableList<ImgInfo> {
        val result: MutableList<ImgInfo> = ArrayList()
        val cursor = context.contentResolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            null,
            MediaStore.Images.Media.MIME_TYPE + "=? or " + MediaStore.Images.Media.MIME_TYPE + "=?",
            arrayOf("image/jpeg", "image/png"),
            MediaStore.Images.Media.DATE_MODIFIED + " desc"
        )

        while (cursor!!.moveToNext()) {
            val path =
                cursor!!.getString(cursor!!.getColumnIndex(MediaStore.Images.Media.DATA))
            result.add(ImgInfo(Uri.parse(path)))
        }
        return result
    }
}