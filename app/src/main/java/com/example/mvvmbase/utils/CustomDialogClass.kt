package com.example.mvvmbase.utils

import android.app.Activity
import android.app.Dialog
import android.view.Window.FEATURE_NO_TITLE
import android.widget.Button
import android.widget.TextView
import com.example.mvvmbase.R

object CustomDialogClass{

    lateinit    var callback:Callback
    fun showDialog(activity: Activity, msg: String, callback: Callback) {

        this.callback=callback
        val dialog = Dialog(activity)
        dialog.requestWindowFeature(FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.layout_dialog)

        val text = dialog.findViewById(R.id.tvMsg) as TextView
        text.text = msg


        val dialogButton = dialog.findViewById(R.id.btnCancel) as Button
        dialogButton.setOnClickListener {

            callback.positiveClick("")
            dialog.dismiss() }

        dialog.show()
    }

    interface Callback{
        fun positiveClick(str:String)
        fun negativeClick(str:String)
    }
}