package com.zpf.photoflash.upload

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zpf.photoflash.upload.entity.ConfigItem
import java.util.ArrayList

class UploadViewModel : ViewModel() {
    private val _configItems = MutableLiveData<MutableList<ConfigItem>>().apply {
        value = initConfigItem()
    }

    val configItems: LiveData<MutableList<ConfigItem>> = _configItems

    private fun initConfigItem(): MutableList<ConfigItem> {
        val items: MutableList<ConfigItem> = ArrayList<ConfigItem>()
        items.add(ConfigItem("上传到", "默认", "","1"))
        items.add(ConfigItem("相册权限", "公开", "","2"))
        items.add(ConfigItem("画质", "正常", "","3"))
        items.add(ConfigItem("地点", "", "","4"))
        return items
    }
}