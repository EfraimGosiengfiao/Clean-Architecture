package com.example.newcleanarchi.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.common.BaseApiResponse
import com.example.domain.model.InitModel
import com.example.domain.model.ProductsModel
import com.example.domain.usecase.MainUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainUseCase: MainUseCase,
) : ViewModel() {

    val errorToaster = MutableLiveData<String>()

    private val _initResponse = MutableLiveData<InitModel>()
    val initResponse : LiveData<InitModel> get() = _initResponse

    fun init() = viewModelScope.launch(Dispatchers.IO) {
        mainUseCase.init().collect{
            BaseApiResponse(it).execute(
                onSuccess = { response -> _initResponse.postValue(response) },
                onError = { errorMsg -> errorToaster.postValue(errorMsg) },
                onLoading = {
                    Log.d("KiritoLoad ", "I'm Loading - init")
                }
            )
        }
    }

    private val _productList = MutableLiveData<ProductsModel>()
    val productList : LiveData<ProductsModel> get() = _productList

    fun getProducts() = viewModelScope.launch(Dispatchers.IO){
        mainUseCase.getProducts().collect{
            BaseApiResponse(it).execute(
                onSuccess = {response -> _productList.postValue(response) },
                onError = { errorMsg -> errorToaster.postValue(errorMsg) },
                onLoading = {
                    Log.d("KiritoLoad ", "I'm Loading - getProducts ")
                }
            )
        }
    }
}