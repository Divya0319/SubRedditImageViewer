package com.assignment.imagessubredditviewer.network

import android.content.Context
import com.google.gson.JsonElement
import io.reactivex.Single
import com.assignment.imagessubredditviewer.App
import javax.inject.Inject

/**
 * Created by Divya Gupta.
 */

/**
 * An intermediate class created which is being used by viewmodels for calling the underlying APICallInterface class methods
 * for making relevant API calls
 */
class Repository(private val apiCallInterface: ApiCallInterface) {

    @Inject
    lateinit var context: Context
    init {
        (App.context as App).appComponent.doInjection(this)

    }

    fun executeImagesApiCall():Single<JsonElement>{
        return apiCallInterface.getImagesData()
    }

}