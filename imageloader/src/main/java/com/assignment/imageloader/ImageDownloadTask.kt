package com.assignment.imageloader

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.util.Log
import android.widget.ImageView
import com.assignment.imageloader.cachemanagement.ImagesCache
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL


/**
 * Created by Divya Gupta.
 */
class ImageDownloadTask constructor() : AsyncTask<String, Void, Bitmap>() {

    private var inSampleSize = 0

    private var imageUrl: String? = null

    private var adapter: ImagesListAdapter? = null

    private var cache: ImagesCache? = null

    private var desiredWidth = 0
    private var desiredHeight: Int = 0

    private var image: Bitmap? = null

    private var ivImageView: ImageView? = null

    constructor(
        adapter: ImagesListAdapter,
        desiredWidth: Int,
        desiredHeight: Int
    ) : this() {
        this.adapter = adapter

        this.cache = ImagesCache.getInstance()

        this.desiredWidth = desiredWidth

        this.desiredHeight = desiredHeight
    }

    constructor(
        cache: ImagesCache,
        ivImageView: ImageView,
        desireWidth: Int,
        desireHeight: Int
    ) : this() {
        this.cache = cache

        this.ivImageView = ivImageView

        this.desiredHeight = desireHeight

        this.desiredWidth = desireWidth
    }

    override fun doInBackground(vararg params: String?): Bitmap? {
        imageUrl = params[0]

        return getImage(imageUrl!!)
    }

    private fun getImage(imageUrl: String): Bitmap? {
        if (cache!!.getImageFromWarehouse(imageUrl) == null) {
            val options = BitmapFactory.Options()
            options.inJustDecodeBounds = true
            options.inSampleSize = inSampleSize
            try {
                val url = URL(imageUrl)
                var connection: HttpURLConnection = url.openConnection() as HttpURLConnection
                var stream: InputStream = connection.inputStream
                image = BitmapFactory.decodeStream(stream, null, options)
                val imageWidth = options.outWidth
                val imageHeight = options.outHeight
                if (imageWidth > desiredWidth || imageHeight > desiredHeight) {
                    println("imageWidth:$imageWidth, imageHeight:$imageHeight")
                    inSampleSize += 2
                    getImage(imageUrl)
                } else {
                    options.inJustDecodeBounds = false
                    connection = url.openConnection() as HttpURLConnection
                    stream = connection.inputStream
                    image = BitmapFactory.decodeStream(stream, null, options)
                    return image
                }
            } catch (e: Exception) {
                Log.e("getImage", e.toString())
            }
        }
        return image
    }


    override fun onPostExecute(result: Bitmap?) {
        super.onPostExecute(result)

        if (result != null) {
            cache?.addImageToWarehouse(imageUrl!!, result)

            if (ivImageView != null) {
                ivImageView?.setImageBitmap(result)
            } else if (adapter != null) {
                adapter?.notifyDataSetChanged()
            }
        }
    }

}