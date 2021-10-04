package com.udacity.shoestore

import android.widget.EditText
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseMethod


object Converter {
    @InverseMethod("getTextString")
    @JvmStatic
    fun setText(value: Double): String {
        if (value == null) return ""
        return value.toString()

    }

    @InverseBindingAdapter(attribute = "android:text", event = "android:textAttrChanged")
    @JvmStatic
    fun getTextString(value: String = ""): Double {
        return value.toDouble()
    }
}