package com.example.foodapp.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapp.model.CatagoryList
import com.example.foodapp.model.MealsByCatagoryList
import com.example.foodapp.model.Meal
import com.example.foodapp.model.RandomMeal
import com.example.foodapp.retrofit.ApiUtils
import com.example.foodapp.roomdb.RoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel:ViewModel() {

  private var  viewdata=MutableLiveData<Meal>()
    private  var mealscatagory=MutableLiveData<MealsByCatagoryList>()
    private  var catagorylive=MutableLiveData<CatagoryList>()
    private  var bottomshhetlivedata=MutableLiveData<Meal>()


     var savestate:Meal?=null

    fun getRandommeal(){
        savestate?.let {
            viewdata.value=savestate
            return
        }
        val kdao= ApiUtils.daofunction()

        kdao.randommeal().enqueue(object : Callback<RandomMeal> {
            override fun onResponse(call: Call<RandomMeal>, response: Response<RandomMeal>) {
                if (response.body()!=null){
                    var list:Meal=response.body()!!.meals[0]
                    viewdata.value=list
                    savestate=list


                    Log.e("mesaj","${list.strMeal}")


                }else{
                    return
                }
            }

            override fun onFailure(call: Call<RandomMeal>, t: Throwable) {

                Log.e("message","${t.message}")
            }

        })

    }


    fun randommealobserver():LiveData<Meal>{

        return viewdata
    }

    fun getmealcatogoryobserve():LiveData<MealsByCatagoryList>{

        return  mealscatagory
    }
    fun getpopularitems(){

        val kdao=ApiUtils.daofunction()

        kdao.getpopularitems("Seafood").enqueue(object :Callback<MealsByCatagoryList>{
            override fun onResponse(call: Call<MealsByCatagoryList>, response: Response<MealsByCatagoryList>) {

                if (response.body()!=null){


                    mealscatagory.value=response.body()!!

                }
            }

            override fun onFailure(call: Call<MealsByCatagoryList>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }


    fun getcatagory(){

        val kdao=ApiUtils.daofunction()
         kdao.getcatagory().enqueue(object :Callback<CatagoryList>{
             override fun onResponse(call: Call<CatagoryList>, response: Response<CatagoryList>) {

                 response.body()?.let {

                     catagorylive.value=response.body()

                 }
             }

             override fun onFailure(call: Call<CatagoryList>, t: Throwable) {
                 Log.e("message",t.message.toString())
             }

         })
    }

    fun getcatagoryobserve():LiveData<CatagoryList>{

        return catagorylive
    }

    fun deletemeal(meal: Meal,context: Context){
        val instance= RoomDatabase.databaseAcces(context)
        viewModelScope.launch(Dispatchers.Default){
            instance?.getroomdao()?.deleteroom(meal)
        }





    }


    fun getBottomsheetdata(mealid:String){

        ApiUtils.daofunction().getmealdetails(mealid).enqueue(object :Callback<RandomMeal>{
            override fun onResponse(call: Call<RandomMeal>, response: Response<RandomMeal>) {

                response.body()?.let {
                    val meal= response.body()!!.meals[0]
                    bottomshhetlivedata.value=meal
                }
            }

            override fun onFailure(call: Call<RandomMeal>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }

    fun getbottomsheetobserve():LiveData<Meal>{

        return  bottomshhetlivedata
    }




}