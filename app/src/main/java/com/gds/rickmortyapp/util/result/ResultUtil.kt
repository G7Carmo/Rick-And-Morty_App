package com.gds.rickmortyapp.util.result

sealed class ResultUtil<out T : Any> {

    data class Success<out T : Any>(val data: T) : ResultUtil<T>()
    data class Error(val msg: String) : ResultUtil<Nothing>()
    object Loading : ResultUtil<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$msg]"
            else-> ""
        }
    }
}