package com.example.foodapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodapp.model.MealsByCatagoryList
import com.example.foodapp.retrofit.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryMealsViewModel:ViewModel() {

     val CategoryBymeals=MutableLiveData<MealsByCatagoryList>()

   fun  getMealsByCatagory(categoryname:String){


    val  kdao=ApiUtils.daofunction()
       kdao.getcatagorymeal(categoryname).enqueue(object :Callback<MealsByCatagoryList>{
           override fun onResponse(call: Call<MealsByCatagoryList>, response: Response<MealsByCatagoryList>) {


          response.body()?.let {

              CategoryBymeals.value=response.body()
          }
           }

           override fun onFailure(call: Call<MealsByCatagoryList>, t: Throwable) {

           }

       })
    }

    fun getObservebycatagoryMeals():LiveData<MealsByCatagoryList>{

        return CategoryBymeals

    }
}