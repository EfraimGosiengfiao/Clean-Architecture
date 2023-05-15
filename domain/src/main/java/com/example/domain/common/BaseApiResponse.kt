package com.example.domain.common

class BaseApiResponse<T : Any>(private val any : NetworkResult<T>){
    fun execute(onSuccess :((t : T)-> Unit), onError :((t : String)-> Unit), onLoading :() -> Unit){
        when(any){
            is NetworkResult.OnSuccess -> {
                if(any.data == null){
                    onError("No data")
                    return
                }
                any.data.let(onSuccess)
            }
            is NetworkResult.OnError -> {
                any.message?.let(onError)
            }
            is NetworkResult.OnLoading -> {
                onLoading.invoke()
            }
        }
    }
}