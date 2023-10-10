package com.example.foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.foodapp.adapter.CatagoryMealsAdapter
import com.example.foodapp.databinding.ActivityCatagoryMealsBinding
import com.example.foodapp.model.MealsByCatagoryList
import com.example.foodapp.viewmodel.CategoryMealsViewModel

class CatagoryMeals : AppCompatActivity() {

    lateinit var binding:ActivityCatagoryMealsBinding
    private   val viewmodel:CategoryMealsViewModel by viewModels()
    lateinit var adapter:CatagoryMealsAdapter
    lateinit var meallist:MealsByCatagoryList
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCatagoryMealsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewmodel.getMealsByCatagory(intent.getStringExtra("catagory")!!)
        viewmodel.getObservebycatagoryMeals().observe(this, Observer {
                 binding.textView4.text=it.meals.size.toString()

             this.meallist=it
            meallist.meals.forEach{ Log.e("message","${it.idMeal}") }
            getcatagorymealsrecycelview()

        })









    }


    fun getcatagorymealsrecycelview(){

        binding.catagorymealsRcyc.apply {
            adapter= CatagoryMealsAdapter(this@CatagoryMeals,meallist)

            adapter=this.adapter
            setHasFixedSize(true)
            layoutManager=GridLayoutManager(this@CatagoryMeals,2)

        }

    }
}