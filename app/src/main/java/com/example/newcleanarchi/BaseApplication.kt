package com.example.newcleanarchi

import android.app.Application
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import dagger.hilt.android.HiltAndroidApp
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ProcessLifecycleOwner

@HiltAndroidApp
class BaseApplication : Application(), LifecycleObserver {

    private val lifecycleObserver = LifecycleEventObserver { _, event ->

        when(event){
            Lifecycle.Event.ON_PAUSE -> {

            }
            Lifecycle.Event.ON_START -> {

            }
            Lifecycle.Event.ON_CREATE -> {

            }
            Lifecycle.Event.ON_STOP -> {

            }
            Lifecycle.Event.ON_RESUME -> {

            }
            Lifecycle.Event.ON_DESTROY -> {

            }
            else -> {}
        }
    }

    override fun onCreate() {
        super.onCreate()
        ProcessLifecycleOwner.get().lifecycle.addObserver(lifecycleObserver)
    }
}