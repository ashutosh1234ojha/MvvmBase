package com.ashutosh1234ojha.mvvmbase.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.ashutosh1234ojha.mvvmbase.viewmodels.BaseViewModel
import com.ashutosh1234ojha.mvvmbase.viewmodels.LoginViewModel


/**
 * Created by Ashutosh Ojha on 21,February,2022
 */
abstract class BaseFragment<T : ViewDataBinding> : Fragment() {
    private lateinit var mViewDataBinding: T
    private lateinit var root: View


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        root = mViewDataBinding.root
        return root
    }

    abstract fun getLayoutId(): Int

    open fun getViewDataBinding(): T {
        return mViewDataBinding
    }

}