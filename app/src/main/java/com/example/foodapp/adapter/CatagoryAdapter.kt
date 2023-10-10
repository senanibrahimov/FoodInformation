package com.example.foodapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodapp.CatagoryMeals
import com.example.foodapp.databinding.CatagoryFoodBinding
import com.example.foodapp.model.Category

class CatagoryAdapter(var context: Context, var list: List<Category>):RecyclerView.Adapter<CatagoryAdapter.viewholder>() {
    class viewholder(var binding: CatagoryFoodBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
     val view=CatagoryFoodBinding.inflate(LayoutInflater.from(context),parent,false)

        return viewholder(view)
    }

    override fun getItemCount(): Int {
 return list.size   }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        Glide.with(holder.itemView).load(list[position].strCategoryThumb).into(holder.binding.catagoryimage)
        holder.binding.textView3.text=list[position].strCategory


        holder.itemView.setOnClickListener {

            val intent=Intent(context,CatagoryMeals::class.java).apply {
                putExtra("catagory",list[position].strCategory)
            }
            holder.itemView.context.startActivity(intent)

        }

    }
}