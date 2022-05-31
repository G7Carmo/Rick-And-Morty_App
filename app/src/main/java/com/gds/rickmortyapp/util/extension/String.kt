package com.gds.rickmortyapp.util.extension

import com.google.android.material.textfield.TextInputLayout

fun String.executeError(textInputLayout: TextInputLayout,msg : String): String {
    this.isEmpty().apply {
        textInputLayout.error = msg
    }
    return this
}