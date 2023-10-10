package com.example.foodapp.roomdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.foodapp.model.Meal
import com.example.foodapp.model.RandomMeal

@Dao
interface DaoRoom {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
 fun insertmealroom(meal: Meal)

    @Delete
     fun deleteroom(meal: Meal)

    @Query("SELECT*FROM MealRoom")
       fun getmealroom():LiveData<List<Meal>>

}