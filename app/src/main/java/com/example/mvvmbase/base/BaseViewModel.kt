package com.example.mvvmbase.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.mvvmbase.utils.ProgressBar

open class BaseViewModel (application: Application) : AndroidViewModel(application) {

    fun showLoader(){
       // ProgressBar.show()
    }
    fun hideLoader(){
     //   ProgressBar.hide()

    }
}