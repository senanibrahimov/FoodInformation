package com.example.foodapp.retrofit

import com.example.foodapp.model.CatagoryList
import com.example.foodapp.model.MealsByCatagoryList
import com.example.foodapp.model.RandomMeal
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Dao {
    @GET("random.php")
     fun randommeal():Call<RandomMeal>

     @GET("lookup.php?")
     fun getmealdetails(@Query("i") id:String):Call<RandomMeal>

     @GET("filter.php?")
    fun getpopularitems(@Query("c") id:String):Call<MealsByCatagoryList>

    @GET("categories.php")
    fun getcatagory():Call<CatagoryList>

    @GET("filter.php")
    fun getcatagorymeal(@Query("c") catagory:String):Call<MealsByCatagoryList>

    @GET("search.php?")
    fun searchmeal(@Query("s") mealname:String):Call<RandomMeal>
}