package com.udacity.shoestore.viewmodel

import androidx.databinding.InverseMethod


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
