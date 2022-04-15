package com.example.home_work_lection_5_1

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ReceiverFragmentModel: ViewModel() {
    var message: MutableLiveData<String> = MutableLiveData<String>()
    var readBtnVisibility: Int = View.VISIBLE
}