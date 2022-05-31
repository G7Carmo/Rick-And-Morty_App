package com.gds.rickmortyapp.util.extension

import android.view.View

fun View.hide(){
    visibility = View.INVISIBLE
}

fun View.show(){
    visibility = View.VISIBLE
}