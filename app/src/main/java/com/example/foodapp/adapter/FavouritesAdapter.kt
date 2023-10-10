package com.example.foodapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodapp.databinding.CatagorybymealsBinding
import com.example.foodapp.databinding.FavouriteRecycelviewBinding
import com.example.foodapp.databinding.FragmentFavouritesBinding
import com.example.foodapp.model.Meal

class FavouritesAdapter(var context:Context, var list: List<Meal>):RecyclerView.Adapter<FavouritesAdapter.viewholder>() {

    class viewholder(var binding: FavouriteRecycelviewBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {

        val view=FavouriteRecycelviewBinding.inflate(LayoutInflater.from(context),parent,false)
          return  viewholder(view)
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {


        Glide.with(context).load(list[position].strMealThumb).into(holder.binding.favouritesimage)
        holder.binding.favouitename.text= list[position].strMeal
    }

    override fun getItemCount(): Int {
return list.size
    }

}