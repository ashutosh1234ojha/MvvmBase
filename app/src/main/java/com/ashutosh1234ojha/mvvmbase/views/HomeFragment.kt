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
import com.ashutosh1234ojha.mvvmbase.viewmodels.HomeViewModel
import com.ashutosh1234ojha.mvvmbase.viewmodels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


/**
 * Created by Ashutosh Ojha on 21,February,2022
 */
@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private val viewModel: HomeViewModel by viewModels()

    private lateinit var homeBinding: FragmentHomeBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeBinding = getViewDataBinding()
//        loginBinding.loginViewModel = viewModel
//        loginBinding.handler = this
//        setErrorListener(viewModel, loginBinding)
        homeBinding.btnRegister.setOnClickListener {
            val name = homeBinding.etName.text.toString()
            val email = homeBinding.etEmail.text.toString()
            val password = homeBinding.etPassword.text.toString()

            viewModel.registerUser(name, email,password)
        }


    }


    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }


}