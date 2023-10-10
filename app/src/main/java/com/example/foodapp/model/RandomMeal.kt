package com.example.foodapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RandomMeal(
     @SerializedName("meals")
     @Expose
    val meals: List<Meal>
)