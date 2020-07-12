package com.assignment.imageloader

import android.annotation.SuppressLint
import android.app.ActivityManager
import android.content.Context
import android.graphics.Bitmap
import android.os.Environment
import java.io.File

/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */ /**
 * Class containing some static utility methods.
 */
object Utils {
    const val IO_BUFFER_SIZE = 8 * 1024

    /**
     * Workaround for bug pre-Froyo, see here for more info:
     * http://android-developers.blogspot.com/2011/09/androids-http-clients.html
     */
    fun disableConnectionReuseIfNecessary() {
        // HTTP connection reuse which was buggy pre-froyo
        if (hasHttpConnectionBug()) {
            System.setProperty("http.keepAlive", "false")
        }
    }

    /**
     * Get the size in bytes of a bitmap.
     * @param bitmap bitmap passed
     * @return size in bytes
     */
    @SuppressLint("NewApi")
    fun getBitmapSize(bitmap: Bitmap): Int {
        return bitmap.byteCount
    }

    /**
     * Check if external storage is built-in or removable.
     *
     * @return True if external storage is removable (like an SD card), false
     * otherwise.
     */
    fun isExternalStorageRemovable(): Boolean {
        return Environment.isExternalStorageRemovable()
    }
    /**
     * Get the external app cache directory.
     *
     * @param context The context to use
     * @return The external cache dir
     */
    @SuppressLint("NewApi")
    fun getExternalCacheDir(context: Context): File? {
        if (hasExternalCacheDir()) {
            return context.externalCacheDir
        }
        // Before Froyo we need to construct the external cache dir ourselves
        val cacheDir = "/Android/data/" + context.packageName + "/cache/"
        return File(
            Environment.getExternalStorageDirectory().path + cacheDir
        )
    }

    /**
     * Check how much usable space is available at a given path.
     *
     * @param path The path to check
     * @return The space available in bytes
     */
    @SuppressLint("NewApi")
    fun getUsableSpace(path: File): Long {
        return path.usableSpace
    }

    /**
     * Get the memory class of this device (approx. per-app memory limit)
     *
     * @param context
     * @return
     */
    fun getMemoryClass(context: Context): Int {
        return (context.getSystemService(
            Context.ACTIVITY_SERVICE
        ) as ActivityManager).memoryClass
    }

    /**
     * Check if OS version has a http URLConnection bug. See here for more information:
     * http://android-developers.blogspot.com/2011/09/androids-http-clients.html
     *
     * @return
     */
    fun hasHttpConnectionBug(): Boolean {
        return false
    }

    /**
     * Check if OS version has built-in external cache dir method.
     *
     * @return
     */
    fun hasExternalCacheDir(): Boolean {
        return true
    }

    /**
     * Check if ActionBar is available.
     *
     * @return
     */
    fun hasActionBar(): Boolean {
        return true
    }
}