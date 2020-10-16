package com.bocahrokok.retrofittesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bocahrokok.retrofittesting.databinding.ActivityMainBinding
import com.bocahrokok.retrofittesting.model.PostModel
import com.bocahrokok.retrofittesting.utils.RetrofitInstance
import com.bocahrokok.retrofittesting.viewmodel.HomeViewModel
import com.bocahrokok.retrofittesting.viewmodel.HomeViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {

        val ListPlaceHolder : MutableList<PostModel> = ArrayList()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val viewModelFactory = HomeViewModelFactory("nurrizky")
        val viewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)

        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        GlobalScope.launch(Dispatchers.IO) {

            try {
                val responses = RetrofitInstance.Api.getPost()

                if(!responses.isSuccessful){
                    throw IllegalArgumentException()
                }

                for (response in responses.body()!!){
                    Log.i("the res:", "$response")
                    ListPlaceHolder.add(response)
                }

                text_for_testing.text = ListPlaceHolder.toString()
                viewModel.textValue = "Hello World"

            } catch (e: Exception){
                Log.e("Error in Instance", e.localizedMessage)
            }
        }


    }
}