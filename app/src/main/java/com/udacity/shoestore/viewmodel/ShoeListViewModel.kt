package com.udacity.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel(listShoe: MutableList<Shoe>): ViewModel() {

    private var listShoeLocal = mutableListOf<Shoe>()
    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    init {
        listShoeLocal.addAll(listShoe)
        _shoeList.value = listShoeLocal
    }

    fun updateShoeList(shoe: Shoe) {
        listShoeLocal.add(shoe)
        _shoeList.value = listShoeLocal
    }
}