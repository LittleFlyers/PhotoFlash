package com.zpf.photoflash.upload.ui

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.zpf.photoflash.upload.R
import com.zpf.photoflash.upload.data.ConfigItem
import kotlinx.android.synthetic.main.config_item_layout.view.*
import kotlin.math.log
import kotlin.properties.Delegates

class ConfigAdapter(context: Context, resource: Int, objects: MutableList<ConfigItem>) :
    ArrayAdapter<ConfigItem>(context, resource, objects) {

    private var mResourceId by Delegates.notNull<Int>()
    private var mConfigItems: MutableList<ConfigItem>
    private var mContext: Context

    init {
        mResourceId = resource
        mConfigItems = objects
        mContext = context
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val item = getItem(position)
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(mContext).inflate(mResourceId, parent, false)
            viewHolder = ViewHolder(
                view.findViewById(R.id.config_item_title),
                view.findViewById(R.id.config_item_content)
            )
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        viewHolder.itemTitle.text = item?.title
        viewHolder.itemContent.text = item?.content
        return view
    }

    inner class ViewHolder(val itemTitle: TextView, val itemContent: TextView)
}