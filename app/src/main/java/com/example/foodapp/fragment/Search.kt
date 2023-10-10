package com.example.foodapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.foodapp.R
import com.example.foodapp.adapter.FavouritesAdapter
import com.example.foodapp.databinding.FragmentSearchBinding
import com.example.foodapp.viewmodel.Searchviewmodel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class Search : Fragment() {

     private lateinit var viewmodel:Searchviewmodel
     lateinit var  binding: FragmentSearchBinding
     lateinit var  adapter: FavouritesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val temviewmodel:Searchviewmodel by viewModels()
        this.viewmodel=temviewmodel


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


          binding=FragmentSearchBinding.inflate(inflater,container,false)
          return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

       binding.imageView2.setOnClickListener { searchmeals() }

        serchviewmodeloberve()
          var job:Job?=null
        binding.searchtext.addTextChangedListener {
             job?.cancel()
            job=lifecycleScope.launch {
                delay(500)
                viewmodel.searchmealfromApi(it.toString())

            }
        }
    }


    fun searchmeals(){

        val searchquery=binding.searchtext.text.toString()
        if (searchquery.isNotEmpty()){
            viewmodel.searchmealfromApi(searchquery)
        }
    }


    fun preparerecycelview(){

    }

    fun serchviewmodeloberve(){


            viewmodel.searchlistoberve().observe(viewLifecycleOwner, Observer {
                it?.let {
                    adapter=FavouritesAdapter(requireContext(),it.meals)
                    binding.searchreycelview.adapter=adapter
                    binding.searchreycelview.layoutManager=GridLayoutManager(requireContext(),2)

                }
            })

    }

}