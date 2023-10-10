package com.example.foodapp.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.adapter.FavouritesAdapter
import com.example.foodapp.databinding.FragmentFavouritesBinding
import com.example.foodapp.model.Meal
import com.example.foodapp.roomdb.RoomDatabase
import com.example.foodapp.viewmodel.FavouritesViewModel
import com.google.android.material.snackbar.Snackbar

class FavouritesFragment : Fragment() {



    lateinit var  binding: FragmentFavouritesBinding
    lateinit var  viewModel: FavouritesViewModel
    lateinit var  adapter1: FavouritesAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       binding=FragmentFavouritesBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temp:FavouritesViewModel by viewModels()
        this.viewModel=temp
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       /* viewModel.getroomQueries(requireContext())
           viewModel.observeroomqueries().observe(viewLifecycleOwner, Observer {


               it?.let {
                   for(i in it){
                       Log.e("mesage","{${i.idMeal}")
                   }
               }

           })*/

         var roomd=RoomDatabase.databaseAcces(requireContext())

        roomd?.getroomdao()?.getmealroom()?.observe(viewLifecycleOwner, Observer {

            adapter1=FavouritesAdapter(requireContext(),it)
            favoritesreycelview()
        })




        var itemtouch=object :ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN,ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return true
              }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                var position=viewHolder.adapterPosition
                var mymeal=adapter1.list[position]
                viewModel.deletemeal(adapter1.list[position],requireContext())

                Snackbar.make(requireView(),"dont you want current item?",Snackbar.LENGTH_LONG).setAction("undo",
                    View.OnClickListener {
                           adapter1.notifyItemChanged(position)
                        viewModel.insertmeal(mymeal,requireContext())
                    }).show()

            }

        }

        ItemTouchHelper(itemtouch).attachToRecyclerView(binding.favoritesReycelview)

    }




    fun favoritesreycelview(){
        binding.favoritesReycelview.apply {
            layoutManager=GridLayoutManager(requireContext(),2)
            adapter=adapter1

        }







    }
}