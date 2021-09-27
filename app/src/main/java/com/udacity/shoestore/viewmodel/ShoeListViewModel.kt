package com.udacity.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel: ViewModel() {

    private var listShoe: MutableList<Shoe> = mutableListOf(
       Shoe("Shoe 1", 30.0, "Nike", "Beautiful nike Shoe", emptyList()),
       Shoe("Shoe 2", 31.0, "Adidas", "Beautiful Adidas Shoe", emptyList()),
       Shoe("Shoe 3", 32.0, "Rebook", "Beautiful Rebook Shoe", emptyList())
   )

    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    init {

        _shoeList.value = listShoe
    }

    fun updateShoeList(shoe: Shoe) {
        listShoe.add(shoe)
        _shoeList.value = listShoe
    }
}