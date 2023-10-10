package com.example.foodapp.BottomSheet

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.foodapp.MealActivity
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentMealBottomSheetBinding
import com.example.foodapp.viewmodel.HomeViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MealBottomSheet(var mealid:String) : BottomSheetDialogFragment() {
    // TODO: Rename and change types of parameters

   private lateinit var  viewModel: HomeViewModel

    lateinit var binding: FragmentMealBottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val temp:HomeViewModel by viewModels()
        this.viewModel=temp

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding=FragmentMealBottomSheetBinding.inflate(inflater,container,false)

        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mealid?.let { viewModel.getBottomsheetdata(it) }

        viewModel.getbottomsheetobserve().observe(viewLifecycleOwner, Observer {

            it?.let {
                Glide.with(requireView()).load(it.strMealThumb).into(binding.imageView)
                binding.bottomsheetMealname.text=it.strMeal
                binding.bottomsheetCatagorytext.text=it.strCategory
                binding.bottomsheetTextLocation.text=it.strArea
            }
            bottomsheetclick(it.idMeal,it.strMeal,it.strMealThumb)
        })





    }

    private fun bottomsheetclick(id:String,name:String?,picture:String?) {

        binding.mealbottomsheetlayout.setOnClickListener {

            val intent=Intent(requireContext(),MealActivity::class.java)
            intent.putExtra("id",id)
            intent.putExtra("name",name)
            intent.putExtra("picture",picture)

             requireContext().startActivity(intent)
        }

    }

}