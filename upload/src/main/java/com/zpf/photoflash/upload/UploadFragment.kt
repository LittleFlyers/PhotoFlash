package com.zpf.photoflash.upload

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.zpf.photoflash.upload.data.ConfigItem
import com.zpf.photoflash.upload.ui.ConfigAdapter

class UploadFragment : Fragment() {

    private lateinit var homeViewModel: UploadViewModel
    private lateinit var mInputPhotoContent: EditText

    //    private lateinit  var mConfigItems: MutableList<ConfigItem>
    private lateinit var mConfigList: ListView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(UploadViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_upload, container, false)
        mInputPhotoContent = root.findViewById(R.id.input_photo_content)
        mConfigList = root.findViewById(R.id.photo_config)
        homeViewModel.configItems.observe(viewLifecycleOwner, Observer {
            val configAdapter =
                ConfigAdapter(context!!, R.layout.config_item_layout, it)
            mConfigList.adapter = configAdapter
        })
        mConfigList.onItemClickListener =
            AdapterView.OnItemClickListener() { _: AdapterView<*>, _: View, position: Int, _: Long ->
                Log.d("UploadFragment", "onCreateView: " + homeViewModel.configItems.value!![position].target)
                //TODO
            }
        return root
    }
}