package com.bocahrokok.retrofittesting.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.Factory

class HomeViewModelFactory(val name : String): Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        //retrieve java class
        if(modelClass.isAssignableFrom(HomeViewModel::class.java)){
            return HomeViewModel(name) as T
        }

        throw IllegalArgumentException("Ilegal Argument Exception in HVM Factory ")

    }
}