package com.gds.rickmortyapp.ui.view.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseWithViewModelActivity<VB : ViewBinding,VM : ViewModel?>  : AppCompatActivity() {
    private var _binding : VB? = null
    protected val binding get() = _binding!!
    private var _viewModel : VM? = null
    protected val viewModel get() = _viewModel!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = getLayoutBinding()
        _viewModel = getMyViewModel()
        setContentView(getViewRoot())
        codeInject()
    }

    abstract fun getLayoutBinding(): VB
    abstract fun getMyViewModel(): VM
    abstract fun getViewRoot(): View
    abstract fun codeInject()
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}