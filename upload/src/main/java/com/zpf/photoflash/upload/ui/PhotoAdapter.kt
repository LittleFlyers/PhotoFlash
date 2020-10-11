package com.zpf.photoflash.upload.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.zpf.photoflash.upload.R
import com.zpf.photoflash.upload.entity.ConfigItem
import com.zpf.photoflash.upload.entity.Photo
import kotlin.properties.Delegates

class PhotoAdapter(context: Context, resource: Int, objects: MutableList<Photo>) :
    ArrayAdapter<Photo>(context, resource, objects) {
    private var mResourceId by Delegates.notNull<Int>()
    private var mConfigItems: MutableList<Photo>
    private var mContext: Context

    init {
        mResourceId = resource
        mConfigItems = objects
        mContext = context
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val item = getItem(position)
        val view: View
        if (convertView == null) {
            view = LayoutInflater.from(mContext).inflate(mResourceId, parent, false)
        } else {
            view = convertView
        }


        return view
    }
}