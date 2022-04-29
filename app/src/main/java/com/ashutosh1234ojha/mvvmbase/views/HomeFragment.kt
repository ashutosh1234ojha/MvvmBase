package com.ashutosh1234ojha.mvvmbase.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ashutosh1234ojha.mvvmbase.R
import com.ashutosh1234ojha.mvvmbase.databinding.FragmentHomeBinding
import com.ashutosh1234ojha.mvvmbase.databinding.FragmentLoginBinding
import com.ashutosh1234ojha.mvvmbase.viewmodels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


/**
 * Created by Ashutosh Ojha on 21,February,2022
 */
@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private val viewModel: LoginViewModel by viewModels()

    private lateinit var loginBinding: FragmentHomeBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginBinding = getViewDataBinding()
//        loginBinding.loginViewModel = viewModel
//        loginBinding.handler = this
//        setErrorListener(viewModel, loginBinding)

    }



    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }


}