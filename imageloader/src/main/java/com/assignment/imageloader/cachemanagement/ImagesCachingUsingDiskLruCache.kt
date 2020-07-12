package com.assignment.imageloader.cachemanagement

import android.graphics.Bitmap

/**
 * Created by Divya Gupta.
 */
open class ImagesCachingUsingDiskLruCache {
    private var imagesWarehouse: DiskLruCache? = null

    companion object {
        var cache: ImagesCachingUsingDiskLruCache? = null


        fun getInstance(): ImagesCachingUsingDiskLruCache {
            if (cache == null) {
                cache =
                    ImagesCachingUsingDiskLruCache()
            }
            return cache!!
        }
    }

    fun initializeCache() {

//        imagesWarehouse =
//            DiskLruCache.openCache(context, DiskLruCache.getDiskCacheDir(context, "CacheFileName"))
    }

    open fun addImageToWarehouse(key: String, value: Bitmap?) {
        if (imagesWarehouse != null && imagesWarehouse!![key] == null) {
            imagesWarehouse?.put(key, value!!)
        }
    }

    open fun getImageFromWarehouse(key: String?): Bitmap? {
        return if (key != null) {
            imagesWarehouse?.get(key)
        } else {
            null
        }
    }

    open fun removeImageFromWarehouse(key: String?) {
//        DiskLruCache.clearCache(context, key!!)
    }

    open fun clearCache() {
        if (imagesWarehouse != null) {
            imagesWarehouse!!.clearCache()
        }
    }
}