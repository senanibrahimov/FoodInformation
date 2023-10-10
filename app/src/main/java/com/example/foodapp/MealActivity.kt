package com.example.foodapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.example.foodapp.databinding.ActivityMealBinding
import com.example.foodapp.model.Meal
import com.example.foodapp.viewmodel.MealDetilsViewModel

class MealActivity : AppCompatActivity() {

    lateinit var binding: ActivityMealBinding
    lateinit var mealid:String
    lateinit var mealPicture:String
    lateinit var mealcontent:String
    lateinit var youtubeUri:String
    lateinit var meal: Meal


    private val viewModel:MealDetilsViewModel by  viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMealBinding.inflate(layoutInflater)
        setContentView(binding.root)
        youtubeiconclick()

        randomloadcase()
       getrandomintent()
        setinformationInviews()
        randomloadcase()

        viewModel.getdetailsmeal(mealid)
          viewModelobserverdetails()


        binding.fabFavourite.setOnClickListener {
            meal?.let {
                viewModel.insertmeal(it,this)
                Toast.makeText(this,"saved",Toast.LENGTH_SHORT).show()

            }
        }

    }

    private fun viewModelobserverdetails() {
   viewModel.getmealdetailsobserve().observe(this,object :Observer<Meal>{
       override fun onChanged(value: Meal) {
                  randomresponsecase()
           binding.catogoryMeal.text="Catagory: ${value!!.strCategory}"
           binding.AreaMeal.text="Area: ${value!!.strArea}"
           binding.deatiltext.text=value.strInstructions
            youtubeUri= value.strYoutube.toString()
           meal=value
       }

   })

    }

    private fun setinformationInviews() {

        Glide.with(this).load(mealPicture).into(binding.imageviewDetail)
        binding.collapsingtoolbar.title=mealcontent
    }

    private fun getrandomintent() {
        val intent=intent
        mealid=intent.getStringExtra("id")!!
        mealPicture=intent.getStringExtra("picture")!!
        mealcontent=intent.getStringExtra("name")!!


    }

    fun randomloadcase(){

        binding.catogoryMeal.visibility= View.INVISIBLE
        binding.AreaMeal.visibility= View.INVISIBLE
        binding.deatiltext.visibility= View.INVISIBLE
        binding.Instructions.visibility= View.INVISIBLE
        binding.progressindicator.visibility= View.VISIBLE
        binding.fabFavourite.visibility= View.INVISIBLE


    }
    fun randomresponsecase(){

        binding.catogoryMeal.visibility= View.VISIBLE
        binding.AreaMeal.visibility= View.VISIBLE
        binding.deatiltext.visibility= View.VISIBLE
        binding.Instructions.visibility= View.VISIBLE
        binding.progressindicator.visibility= View.INVISIBLE
        binding.fabFavourite.visibility= View.VISIBLE


    }

    fun youtubeiconclick(){
     binding.youtubeIcon.setOnClickListener {

         val intent=Intent(Intent.ACTION_VIEW, Uri.parse(youtubeUri))
         startActivity(intent)

     }
    }
}