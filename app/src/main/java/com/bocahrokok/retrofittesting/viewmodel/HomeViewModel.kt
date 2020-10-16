package com.bocahrokok.retrofittesting.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel(val name : String): ViewModel() {

    var textValue: String = "Initialized"

    val textValueLiveData : MutableLiveData<String> = MutableLiveData()


    init {
        Log.i("this is test", "this is name : $name")
        textValueLiveData.value = "String"
    }
}