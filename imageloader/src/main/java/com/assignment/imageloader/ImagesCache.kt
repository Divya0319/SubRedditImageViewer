package com.assignment.imageloader

import android.graphics.Bitmap
import androidx.collection.LruCache

/**
 * Created by Divya Gupta.
 */
open class ImagesCache {
    private var imagesWarehouse: LruCache<String, Bitmap>? = null

    companion object {
        var cache: ImagesCache? = null
        const val DISK_CACHE_SIZE = 1024 * 1024 * 10
        const val DISK_CACHE_SUBDIR = "images"


        fun getInstance(): ImagesCache {
            if (cache == null) {
                cache = ImagesCache()
            }
            return cache!!
        }
    }

    fun initializeCache() {
        val maxMemory = (Runtime.getRuntime().maxMemory() / 1024).toInt()

        val cacheSize = maxMemory / 8

        println("cache size = $cacheSize")

        imagesWarehouse = object : LruCache<String, Bitmap>(cacheSize) {
            override fun sizeOf(key: String, value: Bitmap): Int {
                // The cache size will be measured in kilobytes rather than number of items.
                val bitmapByteCount = value.rowBytes * value.height
                return bitmapByteCount / 1024
            }
        }
    }

    open fun addImageToWarehouse(key: String, value: Bitmap?) {
        if (imagesWarehouse != null && imagesWarehouse!![key] == null) {
            imagesWarehouse?.put(key, value!!)
        }
    }

    open fun getImageFromWarehouse(key: String?): Bitmap? {
        return if (key != null) {
            imagesWarehouse!![key]
        } else {
            null
        }
    }

    open fun removeImageFromWarehouse(key: String?) {
        imagesWarehouse!!.remove(key!!)
    }

    open fun clearCache() {
        if (imagesWarehouse != null) {
            imagesWarehouse!!.evictAll()
        }
    }
}