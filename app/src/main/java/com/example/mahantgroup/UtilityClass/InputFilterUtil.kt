package com.example.mahantgroup.UtilityClass

import android.text.InputFilter
import android.text.InputFilter.LengthFilter
import android.widget.EditText

object InputFilterUtil {
    fun setInputFilter(editText: EditText, maxLength: Int) {
        val filter = arrayOfNulls<InputFilter>(1)
        filter[0] = LengthFilter(maxLength)
        editText.filters = filter
    }
}