package com.assignment.imagessubredditviewer.network

import com.assignment.imagessubredditviewer.commons.Constants
import com.google.gson.JsonElement
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header

/**
 * Created by Divya Gupta.
 */

/**
 * A Retrofit interface class which performs the actual API calls
 */
interface ApiCallInterface {
    @GET(Constants.IMAGES_ENDPOINT)
    fun getImagesData(): Single<JsonElement>
}