package com.example.home_work_lection_5_1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ReceiverFragmentModel: ViewModel() {
    var message: MutableLiveData<String> = MutableLiveData<String>()
    var readBtnVisibility: MutableLiveData<Int> = MutableLiveData<Int>()
}