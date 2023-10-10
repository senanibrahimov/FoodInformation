package com.example.foodapp.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapp.model.Meal
import com.example.foodapp.model.RandomMeal
import com.example.foodapp.retrofit.ApiUtils
import com.example.foodapp.roomdb.RoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealDetilsViewModel():ViewModel() {


      private  var mealsdatil=MutableLiveData<Meal>()

    fun getdetailsmeal(id:String){

        val kdao=ApiUtils.daofunction()
          kdao.getmealdetails(id).enqueue(object :Callback<RandomMeal>{
              override fun onResponse(call: Call<RandomMeal>, response: Response<RandomMeal>) {

                  if (response.body()!=null){
                      val mealdetails= response.body()!!.meals[0]
                      mealsdatil.value=mealdetails

                  }else{
                      return
                  }

              }

              override fun onFailure(call: Call<RandomMeal>, t: Throwable) {
              }

          })
    }




    fun getmealdetailsobserve():LiveData<Meal>{

        return  mealsdatil

    }



    fun insertmeal(meal: Meal,context: Context){
        val instance=RoomDatabase.databaseAcces(context)
        viewModelScope.launch(Dispatchers.Default){
            instance?.getroomdao()?.insertmealroom(meal)
        }

    }

}