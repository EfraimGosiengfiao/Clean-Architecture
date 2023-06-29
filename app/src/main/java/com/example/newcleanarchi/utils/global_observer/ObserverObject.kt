package com.example.newcleanarchi.utils.global_observer

object ObserverObject : CustomObserver() {
    override fun hasChanged(): Boolean {
        return true
    }
}