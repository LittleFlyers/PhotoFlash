package com.zpf.photoflash.upload.album

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.zpf.photoflash.upload.R
import com.zpf.photoflash.upload.entity.ImgInfo


class PhotoListAdapter(private val dataSet: MutableList<MutableList<ImgInfo>>) :
    RecyclerView.Adapter<PhotoListAdapter.PhotoHolder>() {
    class PhotoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img1: ImageView = itemView.findViewById(R.id.imageView1)
        val img2: ImageView = itemView.findViewById(R.id.imageView2)
        val img3: ImageView = itemView.findViewById(R.id.imageView3)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_photo_item, parent)
        return PhotoHolder(view)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        val setData = dataSet[position]
    }
}