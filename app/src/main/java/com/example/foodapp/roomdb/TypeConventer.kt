package com.example.foodapp.roomdb

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.util.jar.Attributes

@TypeConverters
class TypeConventer {
     @TypeConverter
    fun AnytoString(attributes:Any?):String{
        if (attributes==null)
            return ""
        return attributes.toString()
    }

    @TypeConverter
    fun StringToAny(attributes:String?):Any{
        if (attributes==null)
            return ""
        return attributes
    }
}