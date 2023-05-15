package com.example.newcleanarchi.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

fun <T : Any>LifecycleOwner.observe(data: LiveData<T>, function:(T) -> Unit){
    data.observe(this){
        it?.let {function(it)}
    }
}