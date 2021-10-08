package com.udacity.shoestore.viewmodel

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.BR
import com.udacity.shoestore.models.Shoe

class ShoeDetailViewModel : ViewModel(), Observable {

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

    private val _saveShoe = MutableLiveData<Shoe>()
    val saveShoe: LiveData<Shoe>
        get() = _saveShoe

    private val _cancelAction = MutableLiveData<Boolean>()
    val cancelAction: LiveData<Boolean>
        get() = _cancelAction


    fun onSave() {
        _saveShoe.value = Shoe(name.value, size.value, company.value, description.value, emptyList())
    }

    fun onCancel() {
        _cancelAction.value = true
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


}