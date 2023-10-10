package com.example.foodapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodapp.BottomSheet.MealBottomSheet
import com.example.foodapp.MainActivity
import com.example.foodapp.MealActivity
import com.example.foodapp.databinding.PopularReycelviewBinding
import com.example.foodapp.model.MealsByCatagory

class PopularmealAdapter(var context:Context, var arraylist: List<MealsByCatagory>):RecyclerView.Adapter<PopularmealAdapter.viewholder>() {


    class viewholder( var binding: PopularReycelviewBinding):RecyclerView.ViewHolder(binding.root) {

    }



    override fun onBindViewHolder(holder: PopularmealAdapter.viewholder, position: Int) {

        Glide.with(holder.itemView).load(arraylist[position].strMealThumb).into(holder.binding.popularimageview)


        holder.itemView.setOnClickListener {

            val intent=Intent(context,MealActivity::class.java).apply {
                putExtra("id",arraylist[position].idMeal)
                putExtra("name",arraylist[position].strMeal)
                putExtra("picture",arraylist[position].strMealThumb)
            }
            holder.itemView.context.startActivity(intent)
        }

        holder.itemView.setOnLongClickListener(View.OnLongClickListener {
                  val activity=context as MainActivity
                 val mealid=arraylist[position].idMeal
                      var mealbottomsheetfragment=MealBottomSheet(mealid)
                          mealbottomsheetfragment.show(activity.supportFragmentManager,"message")


true        })
    }

    override fun getItemCount(): Int {
       return arraylist.size

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularmealAdapter.viewholder {

        var binding= PopularReycelviewBinding.inflate(LayoutInflater.from(context),parent,false)
        return viewholder(binding)

    }
}