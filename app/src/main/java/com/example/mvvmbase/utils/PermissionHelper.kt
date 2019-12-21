package com.example.mvvmbase.utils

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class PermissionHelper private constructor(private var activity: Activity) {

    lateinit var permissionArray: Array<String>
    val REQUEST_CODE = 101
    lateinit var permissonCallback: PermissionCallback


    companion object : SingletonHolder<PermissionHelper, Activity>(::PermissionHelper)

    fun getPermission(permissions: Array<String>, callback: PermissionCallback) {
        this.permissionArray = permissions
        this.permissonCallback = callback

        checkVersion()
    }

    private fun checkVersion() {

        return if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP_MR1 || checkIfAlreadyhavePermission()) {
            permissonCallback.onPermissionGranted()
        } else {
            requestForSpecificPermission()

        }
    }

    private fun requestForSpecificPermission() {
        ActivityCompat.requestPermissions(
            activity,
            permissionArray,
            REQUEST_CODE
        )
    }

    fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            REQUEST_CODE -> if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //granted

                permissonCallback.onPermissionGranted()

            } else {
                //not granted
                permissonCallback.onPermissionDenied()
            }
            //  else -> super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        }
    }

    private fun checkIfAlreadyhavePermission(): Boolean {
        val result = ContextCompat.checkSelfPermission(activity, Manifest.permission.GET_ACCOUNTS)
        return result == PackageManager.PERMISSION_GRANTED
    }


    interface PermissionCallback {
        fun onPermissionGranted()
        fun onPermissionDenied()
    }

}