package com.example.retrofitwithcoroutines.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitwithcoroutines.models.MainResponse
import com.example.retrofitwithcoroutines.network.RetrofitClient
import kotlinx.coroutines.launch


/**
 * Ahmed Ali Ebaid
 * ahmedali26002844@gmail.com
 * 20/02/2021
 */
class MainViewModel : ViewModel() {
    private var mutableList: MutableLiveData<MainResponse>? = null

    init {
        mutableList = MutableLiveData()
    }

    fun getResponse() {
        viewModelScope.launch {
            var res = RetrofitClient.getRetrofitClient().getPostsService()
            Log.d("Ahmed", "getResponse: ${res.code()}")
            if (res.isSuccessful && res != null) {
                mutableList?.postValue(res.body())
                Log.d("Ahmed", "getResponse: ${res.body().toString()}")

            } else {
                Log.d("Ahmed", "getResponse: ${res.errorBody().toString()}")
            }

        }
    }

    fun getMutableList(): MutableLiveData<MainResponse>? {
        getResponse()
        return mutableList
    }
}