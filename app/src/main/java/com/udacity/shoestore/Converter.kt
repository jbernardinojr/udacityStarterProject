package com.udacity.shoestore

import android.widget.EditText
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseMethod
import java.util.Locale

import android.content.res.Resources

import android.view.View

import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import java.text.DecimalFormat
import java.text.NumberFormat
import java.text.ParseException


object Converter {

    @InverseMethod("stringToDouble")
    @JvmStatic
    fun doubleToString(value: Double): String {
        var setValue = value.toString().isEmpty()
        try {
            if (!setValue) {
                return value.toString()
            }
        } catch (e: NumberFormatException) {
            return "0.0"
        }

        return "0.0"
    }

    @JvmStatic
    fun stringToDouble(value: String): Double {
        return try {
            value.toDouble()
        } catch (e: NumberFormatException) {
            0.0
        }
    }
}
