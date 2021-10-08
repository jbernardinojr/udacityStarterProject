package com.udacity.shoestore.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.models.Shoe

class ShoesListViewModelFactory (private val listShoe: MutableList<Shoe>): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShoeListViewModel::class.java)) {
            return ShoeListViewModel(listShoe) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}