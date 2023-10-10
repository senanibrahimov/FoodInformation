package com.example.foodapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodapp.model.RandomMeal
import com.example.foodapp.retrofit.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Searchviewmodel:ViewModel() {
    private  var searchobservelist= MutableLiveData<RandomMeal>()

    fun searchmealfromApi(meal:String){


        ApiUtils.daofunction().searchmeal(meal).enqueue(object : Callback<RandomMeal> {
            override fun onResponse(call: Call<RandomMeal>, response: Response<RandomMeal>) {
                response.body()?.let {

                    searchobservelist.value= response.body()
                }
            }

            override fun onFailure(call: Call<RandomMeal>, t: Throwable) {


            }

        })
    }

    fun searchlistoberve(): LiveData<RandomMeal> {

        return  searchobservelist

    }
}