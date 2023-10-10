package com.example.foodapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.foodapp.databinding.CatagoryFoodBinding
import com.example.foodapp.databinding.CatagorybymealsBinding
import com.example.foodapp.model.MealsByCatagoryList

class CatagoryMealsAdapter(var context: Context,var list:MealsByCatagoryList): RecyclerView.Adapter<CatagoryMealsAdapter.viewholder>() {
    class viewholder(var binding: CatagorybymealsBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val view=CatagorybymealsBinding.inflate(LayoutInflater.from(context),parent,false)
        return  viewholder(view)
    }

    override fun getItemCount(): Int {
        return list.meals.size
     }

     override fun onBindViewHolder(holder: viewholder, position: Int) {

         Glide.with(holder.itemView).load(list.meals[position].strMealThumb).into(holder.binding.mealsimage)
          holder.binding.mealname.text=list.meals[position].strMeal
    }
}