package com.borbi.boogiemeter

import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager

class Utils {

    private fun handleKeyEvent(context: Context, view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            // Hide the keyboard
            val inputMethodManager =
                    context.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }
}