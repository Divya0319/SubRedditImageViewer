package com.assignment.imagessubredditviewer

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.assignment.imagessubredditviewer.commons.Utils
import com.assignment.imagessubredditviewer.network.ApiResponse
import com.assignment.imagessubredditviewer.network.Status
import com.google.gson.JsonElement
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainActivityVMFactory: MainActivityVMFactory

    private lateinit var alertDialogBuilder: AlertDialog.Builder
    private lateinit var dialog: Dialog
    private lateinit var mainActivityViewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setView(R.layout.progress_dialog_with_message)
        dialog = alertDialogBuilder.create()
        dialog.setCancelable(false)

        (application as App).appComponent.doInjection(this)

        mainActivityViewModel =
            ViewModelProvider(this, mainActivityVMFactory)[MainActivityViewModel::class.java]

        mainActivityViewModel.homeScreenResponse.observe(this, Observer { consumeApiResponse(it) })

        mainActivityViewModel.hitImagesApi()
    }

    private fun consumeApiResponse(apiResponse: ApiResponse?) {
        when (apiResponse?.status) {
            Status.SUCCESS -> {
                hideProgressDialog()
                renderSuccessResponse(apiResponse.data)
            }

            Status.ERROR -> {
                hideProgressDialog()
                renderErrorResponse(apiResponse.error)
            }

            Status.LOADING -> {
                showProgressDialog()
            }

            else -> Log.d("APIStatus", "Unknown")
        }

    }

    private fun showProgressDialog() {
        if (!dialog.isShowing) {
            dialog.show()
        }
    }

    private fun hideProgressDialog() {
        if (dialog.isShowing)
            dialog.dismiss()
    }

    private fun renderErrorResponse(error: Throwable?) {
        Toast.makeText(this, "Some error occured ${error?.message}", Toast.LENGTH_LONG).show()
    }

    private fun renderSuccessResponse(data: JsonElement?) {
        val jsonObject = data?.asJsonObject
        Log.d("----", "-----------------------------------")
        Log.d("ImagesResponse", Utils.toPrettyFormat(jsonObject.toString()))
        Log.d("----", "-----------------------------------")
    }
}