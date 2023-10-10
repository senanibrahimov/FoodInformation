package com.example.foodapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.foodapp.R
import com.example.foodapp.adapter.CatagoryAdapter
import com.example.foodapp.databinding.FragmentCatagoryBinding
import com.example.foodapp.viewmodel.HomeViewModel


class CatagoryFragment : Fragment() {

    lateinit var binding: FragmentCatagoryBinding
    lateinit var viewModel: HomeViewModel
     lateinit var adapter1:CatagoryAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        binding= FragmentCatagoryBinding.inflate(inflater,container,false)
        return binding.root






    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temp:HomeViewModel by viewModels()
        this.viewModel=temp

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getcatagory()
        viewModel.getcatagoryobserve().observe(viewLifecycleOwner, Observer {



              adapter1=CatagoryAdapter(requireContext(),it.categories)
                binding.reycelview.adapter=adapter1
                binding.reycelview.layoutManager=GridLayoutManager(requireContext(),3)


        })

    }


    fun catagoryreycelview(){



    }


}