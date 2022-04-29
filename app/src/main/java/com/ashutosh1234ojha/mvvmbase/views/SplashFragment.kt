package com.ashutosh1234ojha.mvvmbase.views

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.ashutosh1234ojha.mvvmbase.R
import com.ashutosh1234ojha.mvvmbase.databinding.FragmentSplashBinding
import com.ashutosh1234ojha.mvvmbase.viewmodels.SplashViewModel
import kotlinx.coroutines.flow.collect


/**
 * Created by Ashutosh Ojha on 21,February,2022
 */
class SplashFragment : BaseFragment<FragmentSplashBinding>() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_splash
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val splashViewMode: SplashViewModel by viewModels()
        lifecycleScope.launchWhenResumed {
            splashViewMode.stateFlow.collect {
                if (it) {
                    findNavController().navigate(R.id.from_splash_to_login)
                }
            }
        }
    }


}