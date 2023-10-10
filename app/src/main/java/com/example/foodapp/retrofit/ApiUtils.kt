package com.example.foodapp.retrofit

class ApiUtils {
    companion object{

        val baseurl="https://www.themealdb.com/api/json/v1/1/"

        fun daofunction():Dao{
            return RetrofitClient.Retrofitbuilder(baseurl).create(Dao::class.java)
        }
    }
}