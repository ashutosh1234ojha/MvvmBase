package com.example.mvvmbase.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import com.example.mvvmbase.R

@SuppressLint("StaticFieldLeak")
object ProgressBar {

    private val TAG = ProgressBar::class.java.getSimpleName()

    private var activity: Activity? = null

    private var progressDialog: Dialog? = null
    private var tvProgress: TextView? = null


    fun show(activity: Activity) {

        //        show(activity, StorefrontCommonData.getString(activity,R.string.loading_text));
        show(activity, "")
    }


    fun show(context: Activity, message: String) {

        activity = context

        try {

            /* Check if the last instance is alive */
            if (progressDialog != null)
                if (progressDialog!!.isShowing) {
                    // tvProgress.setText(message);
                    return
                }

            /*  Ends Here   */

            progressDialog = Dialog(activity!!, R.style.Theme_AppCompat_Translucent)

            progressDialog!!.setContentView(R.layout.progress_bar)

            tvProgress = progressDialog!!.findViewById(R.id.tvProgress)
           // tvProgress!!.typeface = Font.getRegular(activity)
            tvProgress!!.text = message
            tvProgress!!.visibility = View.GONE

            //            ((ProgressWheel) progressDialog.findViewById(R.id.progress_wheel)).spin();

            val dialogWindow = progressDialog!!.window
            val layoutParams = dialogWindow!!.attributes
            layoutParams.dimAmount = 0.6f
            dialogWindow.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
            progressDialog!!.setCancelable(false)
            progressDialog!!.setCanceledOnTouchOutside(false)

            progressDialog!!.show()


        } catch (e: WindowManager.BadTokenException) {
            //e.printStackTrace();
            Log.e(TAG, "Exception: " + e.message)
        } catch (e: Exception) {
            //e.printStackTrace();
            Log.e(TAG, "Exception: " + e.message)
        }

    }


    fun dismiss() {

        // Check if activity lives
        if (activity != null)
        // Check if the Dialog is null
            if (progressDialog != null)
            // Check whether the progressDialog is visible
                if (progressDialog!!.isShowing) {
                    try {
                        // Dismiss the Dialog
                        progressDialog!!.dismiss()
                        progressDialog = null
                    } catch (ex: Exception) {
                                          ex.printStackTrace();
                    }

                }
    }
}