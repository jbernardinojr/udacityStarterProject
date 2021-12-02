package com.udacity.shoestore.viewmodel

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.BR
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : Observable, ViewModel() {

    @Bindable
    var name = MutableLiveData<String>()
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }

    @Bindable
    var company = MutableLiveData<String>()
        set(value) {
            field = value
            notifyPropertyChanged(BR.company)
        }

    @Bindable
    var description = MutableLiveData<String>()
        set(value) {
            field = value
            notifyPropertyChanged(BR.description)
        }

    @Bindable
    var size = MutableLiveData<Double>()
        set(value) {
            field = value
            notifyPropertyChanged(BR.size)
        }

    private val _cancelAction = MutableLiveData<Boolean>()
    val cancelAction: LiveData<Boolean>
        get() = _cancelAction

    private val _saveAction = MutableLiveData<Boolean>()
    val saveAction: LiveData<Boolean>
        get() = _saveAction

    private var _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList : LiveData<MutableList<Shoe>>
        get() = _shoeList

    init {
        startInitialShoeList()
    }

    private fun startInitialShoeList() {
        _shoeList.value = mutableListOf(
            Shoe("Sports Arizona", 41.0, "Adidas", "Best for sports"),
            Shoe("Nike Air Jordan", 39.5, "Nike", "Popular choice for basketball"),
            Shoe("Tennis shoes", 39.0, "Nike", "Best for tennis "),
            Shoe("The Wic Boots", 35.0, "Nine West", "Best for sports"),
            Shoe("Rider Bootie", 39.0, "Nine West", "Fashionable and comfortable"),
            Shoe("Classic Boots", 43.5, "Caterpillar", "Casual and comfortable")
        )
        _saveAction.value = false
    }

    fun onCancel() {
        _cancelAction.value = true
        _saveAction.value = false
    }

    fun onSave() {
        var shoe = Shoe(
            name = name.value,
            size = size.value,
            description = description.value,
            company = company.value,
        )
        _shoeList.value?.add(shoe)
        _saveAction.value = true
        _cancelAction.value = false
    }

    fun onSavedComplete(){
        _saveAction.value = false
    }

    fun onCancelComplete(){
        _cancelAction.value = false
    }
    private val callbacks: PropertyChangeRegistry = PropertyChangeRegistry()

    override fun addOnPropertyChangedCallback(
        callback: Observable.OnPropertyChangedCallback
    ) {
        callbacks.add(callback)
    }

    override fun removeOnPropertyChangedCallback(
        callback: Observable.OnPropertyChangedCallback
    ) {
        callbacks.remove(callback)
    }

    /**
     * Notifies observers that all properties of this instance have changed.
     */
    fun notifyChange() {
        callbacks.notifyCallbacks(this, 0, null)
    }

    /**
     * Notifies observers that a specific property has changed. The getter for the
     * property that changes should be marked with the @Bindable annotation to
     * generate a field in the BR class to be used as the fieldId parameter.
     *
     * @param fieldId The generated BR id for the Bindable field.
     */
    private fun notifyPropertyChanged(fieldId: Int) {
        callbacks.notifyCallbacks(this, fieldId, null)
    }

    fun showShoe(shoe: Shoe) {
        name.value = shoe.name
        company.value = shoe.company
        description.value = shoe.description
        size.value = shoe.size
    }

    fun resetListOfShoes(){
        startInitialShoeList()
    }
}