package com.example.foodapp.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.TypeConverters
import com.example.foodapp.model.Meal

@Database(entities =[Meal::class], version = 1)
@TypeConverters(TypeConventer::class)
abstract class RoomDatabase:androidx.room.RoomDatabase() {


    abstract fun getroomdao():DaoRoom

    companion object{
        var INSTANCE:RoomDatabase?=null

        fun databaseAcces(context: Context):RoomDatabase?{
            if (INSTANCE==null){
                synchronized(RoomDatabase::class){
                    INSTANCE=Room.databaseBuilder(context.applicationContext,RoomDatabase::class.java,"mymealroom.db").createFromAsset("mymealroom.db").build()
                }
            }
return INSTANCE
        }
    }
}