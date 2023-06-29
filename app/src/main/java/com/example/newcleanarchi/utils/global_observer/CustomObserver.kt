package com.example.newcleanarchi.utils.global_observer

import java.util.Vector

open class CustomObserver {

    private var hasChanged = false
    private var observers : Vector<GlobalObserver>? = null

    init {
        observers = Vector()
    }

    @Synchronized
    fun addObserver(o : GlobalObserver?){
        if(o == null) throw NullPointerException()
        if(observers?.contains(o) == false)
            observers?.addElement(o)
    }

    @Synchronized
    fun deleteObserver(o : GlobalObserver?){
        observers?.removeElement(o)
    }

    fun notifyObservers(){
        notifyObservers(null)
    }

    fun notifyObservers(arg: Any?){
        var arrLocal : Array<Any>
        synchronized(this){
            if(!hasChanged()) return
            arrLocal = observers?.toTypedArray()!!
            clearChanged()
        }

        for(i in arrLocal.indices.reversed()) (arrLocal[i] as GlobalObserver).update(arg)
    }

    @Synchronized
    open fun hasChanged() = hasChanged

    @Synchronized
    fun clearChanged() {
        hasChanged = false
    }
}