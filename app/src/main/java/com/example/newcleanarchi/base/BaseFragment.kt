package com.example.newcleanarchi.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import androidx.lifecycle.ViewModel
import kotlin.reflect.KClass

abstract class BaseFragment<VB : ViewDataBinding, VM: ViewModel>(
    private val bindingInflater : (inflater: LayoutInflater) -> VB,
    model : KClass<out VM>
) : Fragment() {

    val viewModel : VM by createViewModelLazy(model, { viewModelStore })
    private var _binding: VB? = null
    val binding : VB get() = _binding.let { binding ->

        when(binding){
            null -> bindingInflater(layoutInflater)
            else -> binding
        }

    }

    open fun VB.initialize(){}
    open fun VM.initObserver(){}
    open fun VM.initCall(){}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater(layoutInflater)
        viewModel.initCall()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.initialize()
        viewModel.initObserver()
        return binding.root
    }


}