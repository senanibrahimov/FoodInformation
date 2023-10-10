package com.example.foodapp.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.foodapp.MealActivity
import com.example.foodapp.R
import com.example.foodapp.adapter.CatagoryAdapter
import com.example.foodapp.adapter.PopularmealAdapter
import com.example.foodapp.databinding.FragmentHomeBinding
import com.example.foodapp.model.CatagoryList
import com.example.foodapp.model.MealsByCatagoryList
import com.example.foodapp.model.Meal
import com.example.foodapp.viewmodel.HomeViewModel

class HomeFragment : Fragment() {

    lateinit var binding:FragmentHomeBinding
    private lateinit var viewmodel:HomeViewModel
    private lateinit var  randommeal:Meal
    private lateinit var  catagory: MealsByCatagoryList
    private lateinit var  catagoryofMeals: CatagoryList

    lateinit var popularReycelviewadapter:PopularmealAdapter
    lateinit var catagoryAdapter: CatagoryAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempmodel:HomeViewModel by viewModels()
        this.viewmodel=tempmodel
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding= FragmentHomeBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
          menuprovider()

        viewmodel.getRandommeal()
        viewmodel.randommealobserver().observe(viewLifecycleOwner,{it->
            Glide.with(this@HomeFragment)
                .load(it.strMealThumb)
                .into(binding.imageRandom)

            this.randommeal=it
        })
        onrandomcardclick()


        viewmodel.getpopularitems()
        viewmodel.getmealcatogoryobserve().observe(viewLifecycleOwner,{

               this.catagory=it
            popularreycelview()


        })


        viewmodel.getcatagory()
        viewmodel.getcatagoryobserve().observe(viewLifecycleOwner, Observer {

            this.catagoryofMeals=it
            catagoryRecycelview()

        })

    }




    private fun popularreycelview() {
      binding.recyclerView.apply {
          popularReycelviewadapter= PopularmealAdapter(requireContext(),catagory.meals)
          layoutManager=LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
          adapter=popularReycelviewadapter
      }

    }

    private fun onrandomcardclick() {
        binding.randomimageCardview.setOnClickListener {

            val intent=Intent(activity,MealActivity::class.java)
            intent.putExtra("id",randommeal.idMeal)
            intent.putExtra("name",randommeal.strMeal)
            intent.putExtra("picture",randommeal.strMealThumb)
            startActivity(intent)
        }
     }



    fun catagoryRecycelview(){

        catagoryAdapter=CatagoryAdapter(requireContext(),catagoryofMeals.categories)
         binding.catagoryScrollview.layoutManager=GridLayoutManager(requireContext(),3)
        binding.catagoryScrollview.adapter=catagoryAdapter
    }

    fun goToSearchFragment(){

    }

    fun menuprovider(){

        requireActivity().addMenuProvider(object :MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {

                menuInflater.inflate(R.menu.search,menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                if (menuItem.itemId==R.id.search){

                    Navigation.findNavController(requireView()).navigate(R.id.action_homeFragment_to_search22)
                }
                return true
            }

        },viewLifecycleOwner,Lifecycle.State.RESUMED)
    }




}