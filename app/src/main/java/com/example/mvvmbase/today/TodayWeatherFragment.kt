package com.example.mvvmbase.today

import android.Manifest
import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.mvvmbase.MainActivity

import com.example.mvvmbase.R
import com.example.mvvmbase.base.BaseFragment
import com.example.mvvmbase.utils.PermissionHelper
import com.example.mvvmbase.utils.ProgressBar
import kotlinx.android.synthetic.main.today_weather_fragment.*

class TodayWeatherFragment : BaseFragment() {
  lateinit  var activity:MainActivity
    override fun layoutResId(): Int {

        return R.layout.today_weather_fragment
    }

    companion object {
        fun newInstance() = TodayWeatherFragment()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        activity= context as MainActivity
    }

    private lateinit var viewModel: TodayWeatherViewModel



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TodayWeatherViewModel::class.java)

    //    activity?.let { ProgressBar.show(it) }


        viewModel.liveBaseResponse.observe(this, Observer {

            ProgressBar.dismiss()
            tvText.text=it.toString()
        })

      //  viewModel.login("London","en")


            PermissionHelper.getInstance( activity)
                .getPermission(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),object :PermissionHelper.PermissionCallback{
                    override fun onPermissionGranted() {

                    }

                    override fun onPermissionDenied() {
                    }

                })





    }

//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//       PermissionHelper.getInstance(activity).onRequestPermissionsResult(requestCode, permissions, grantResults)
//    }

}
