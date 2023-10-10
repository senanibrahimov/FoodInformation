package com.example.foodapp.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapp.model.Meal
import com.example.foodapp.roomdb.RoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavouritesViewModel:ViewModel() {




    /*  var roomlive=MutableLiveData<List<Meal>?>()
     var allqueies:List<Meal>?=null

    fun  getroomQueries(context:Context){
        val roomInstance=RoomDatabase.databaseAcces(context)

        viewModelScope.launch(Dispatchers.Default){
             allqueies= roomInstance?.getroomdao()?.getmealroom()

        }
        roomlive.value=allqueies
*/

    fun favourites(context: Context):LiveData<List<Meal>>{

        var ins=RoomDatabase.databaseAcces(context)
        var mutabe=ins?.getroomdao()?.getmealroom()

        return mutabe!!

    }
    fun deletemeal(meal: Meal,context: Context){
        val instance=RoomDatabase.databaseAcces(context)
        viewModelScope.launch(Dispatchers.Default){
            instance?.getroomdao()?.deleteroom(meal)
        }

    }
    fun insertmeal(meal: Meal,context: Context) {
        val instance = RoomDatabase.databaseAcces(context)
        viewModelScope.launch(Dispatchers.Default) {
            instance?.getroomdao()?.insertmealroom(meal)
        }

    }



}