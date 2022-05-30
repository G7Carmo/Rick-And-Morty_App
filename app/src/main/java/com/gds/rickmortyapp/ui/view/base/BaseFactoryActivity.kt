package com.gds.rickmortyapp.ui.view.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.gds.rickmortyapp.ui.viewmodel.ViewModelFactory

abstract class BaseFactoryActivity<VB : ViewBinding,VM : ViewModelFactory>  : AppCompatActivity() {
    private var _binding : VB? = null
    protected val binding get() = _binding!!
    abstract val viewModel : VM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = getLayoutBinding()
        setContentView(getViewRoot())
        codeInject()
    }
    abstract fun getLayoutBinding(): VB
    abstract fun getViewRoot(): View
    abstract fun codeInject()
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}