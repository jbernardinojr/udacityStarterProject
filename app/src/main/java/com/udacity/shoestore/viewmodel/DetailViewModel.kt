package com.udacity.shoestore.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.udacity.shoestore.BR

class DetailViewModel: BaseObservable() {

    var name: String = ""
        @Bindable get() = name
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }

    var company: String = ""
        @Bindable get() = company
        set(value) {
            field = value
            notifyPropertyChanged(BR.company)
        }

    var description: String = ""
        @Bindable get() = description
        set(value) {
            field = value
            notifyPropertyChanged(BR.description)
        }

}