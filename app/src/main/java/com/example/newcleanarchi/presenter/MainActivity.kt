package com.example.newcleanarchi.presenter

import android.widget.Toast
import androidx.activity.viewModels
import com.example.domain.common.NetworkResult
import com.example.domain.model.InitModel
import com.example.domain.model.ProductsModel
import com.example.newcleanarchi.base.BaseActivity
import com.example.newcleanarchi.databinding.ActivityMainBinding
import com.example.newcleanarchi.utils.observe
import com.example.newcleanarchi.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(
    ActivityMainBinding::inflate
) {

    private val mainViewModel : MainViewModel by viewModels()

    override fun ActivityMainBinding.initCall() {
        mainViewModel.init()
        mainViewModel.getProducts()
    }

    override fun ActivityMainBinding.initObserver() {
        mainViewModel.errorToaster.observe(this@MainActivity){
            Toast.makeText(this@MainActivity, it, Toast.LENGTH_SHORT).show()
        }
        mainViewModel.initResponse.observe(this@MainActivity){
            initText(it)
        }
        mainViewModel.productList.observe(this@MainActivity){
            getProducts(it)
        }
    }

    private fun initText(initModel: InitModel){
        binding.InitMessage.text = initModel.toString()
    }

    private fun getProducts(productsModel: ProductsModel){
        binding.products.text = productsModel.toString()
    }

}