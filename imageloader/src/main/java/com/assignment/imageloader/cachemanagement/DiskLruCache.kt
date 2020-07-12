package com.assignment.imageloader.cachemanagement

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Bitmap.CompressFormat
import android.graphics.BitmapFactory
import android.os.Environment
import android.util.Log
import com.assignment.imageloader.BuildConfig
import com.assignment.imageloader.Utils
import java.io.*
import java.net.URLEncoder
import java.util.*

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
 * A simple disk LRU bitmap cache to illustrate how a disk cache would be used for bitmap caching. A
 * much more robust and efficient disk LRU cache solution can be found in the ICS source code
 * (libcore/luni/src/main/java/libcore/io/DiskLruCache.java) and is preferable to this simple
 * implementation.
 */
class DiskLruCache private constructor(private val mCacheDir: File, maxByteSize: Long) {
    private var cacheSize = 0
    private var cacheByteSize = 0
    private val maxCacheItemSize = 64 // 64 item default
    private var maxCacheByteSize = 1024 * 1024 * 5 // 5MB default
        .toLong()
    private var mCompressFormat = CompressFormat.JPEG
    private var mCompressQuality = 70
    private val mLinkedHashMap =
        Collections.synchronizedMap(
            LinkedHashMap<String, String?>(
                INITIAL_CAPACITY,
                LOAD_FACTOR,
                true
            )
        )

    /**
     * Add a bitmap to the disk cache.
     *
     * @param key  A unique identifier for the bitmap.
     * @param data The bitmap to store.
     */
    fun put(key: String, data: Bitmap) {
        synchronized(mLinkedHashMap) {
            if (mLinkedHashMap[key] == null) {
                try {
                    val file =
                        createFilePath(
                            mCacheDir,
                            key
                        )
                    if (writeBitmapToFile(data, file)) {
                        put(key, file)
                        flushCache()
                    }
                } catch (e: IOException) {
                    Log.e(
                        TAG,
                        "Error in put: " + e.message
                    )
                }
            }
        }
    }

    private fun put(key: String, file: String?) {
        mLinkedHashMap[key] = file
        cacheSize = mLinkedHashMap.size
        cacheByteSize += File(file).length().toInt()
    }

    /**
     * Flush the cache, removing oldest entries if the total size is over the specified cache size.
     * Note that this isn't keeping track of stale files in the cache directory that aren't in the
     * HashMap. If the images and keys in the disk cache change often then they probably won't ever
     * be removed.
     */
    private fun flushCache() {
        var eldestEntry: Map.Entry<String, String?>
        var eldestFile: File
        var eldestFileSize: Long
        var count = 0
        while (count < MAX_REMOVALS &&
            (cacheSize > maxCacheItemSize || cacheByteSize > maxCacheByteSize)
        ) {
            eldestEntry = mLinkedHashMap.entries.iterator().next()
            eldestFile = File(eldestEntry.value)
            eldestFileSize = eldestFile.length()
            mLinkedHashMap.remove(eldestEntry.key)
            eldestFile.delete()
            cacheSize = mLinkedHashMap.size
            cacheByteSize -= eldestFileSize.toInt()
            count++
            if (BuildConfig.DEBUG) {
                Log.d(
                    TAG,
                    "flushCache - Removed cache file, " + eldestFile + ", "
                            + eldestFileSize
                )
            }
        }
    }

    /**
     * Get an image from the disk cache.
     *
     * @param key The unique identifier for the bitmap
     * @return The bitmap or null if not found
     */
    operator fun get(key: String): Bitmap? {
        synchronized(mLinkedHashMap) {
            val file = mLinkedHashMap[key]
            if (file != null) {
                if (BuildConfig.DEBUG) {
                    Log.d(
                        TAG,
                        "Disk cache hit"
                    )
                }
                return BitmapFactory.decodeFile(file)
            } else {
                val existingFile =
                    createFilePath(
                        mCacheDir,
                        key
                    )
                if (File(existingFile).exists()) {
                    put(key, existingFile)
                    if (BuildConfig.DEBUG) {
                        Log.d(
                            TAG,
                            "Disk cache hit (existing file)"
                        )
                    }
                    return BitmapFactory.decodeFile(existingFile)
                }
            }
            return null
        }
    }

    /**
     * Checks if a specific key exist in the cache.
     *
     * @param key The unique identifier for the bitmap
     * @return true if found, false otherwise
     */
    fun containsKey(key: String): Boolean {
        // See if the key is in our HashMap
        if (mLinkedHashMap.containsKey(key)) {
            return true
        }
        // Now check if there's an actual file that exists based on the key
        val existingFile =
            createFilePath(
                mCacheDir,
                key
            )
        if (File(existingFile).exists()) {
            // File found, add it to the HashMap for future use
            put(key, existingFile)
            return true
        }
        return false
    }

    /**
     * Removes all disk cache entries from this instance cache dir
     */
    fun clearCache() {
        clearCache(
            mCacheDir
        )
    }

    /**
     * Create a constant cache file path using the current cache directory and an image key.
     *
     * @param key
     * @return
     */
    fun createFilePath(key: String): String? {
        return createFilePath(
            mCacheDir,
            key
        )
    }

    /**
     * Sets the target compression format and quality for images written to the disk cache.
     *
     * @param compressFormat
     * @param quality
     */
    fun setCompressParams(compressFormat: CompressFormat, quality: Int) {
        mCompressFormat = compressFormat
        mCompressQuality = quality
    }

    /**
     * Writes a bitmap to a file. Call [DiskLruCache.setCompressParams]
     * first to set the target bitmap compression and format.
     *
     * @param bitmap
     * @param file
     * @return
     */
    @Throws(IOException::class, FileNotFoundException::class)
    private fun writeBitmapToFile(bitmap: Bitmap, file: String?): Boolean {
        var out: OutputStream? = null
        return try {
            out = BufferedOutputStream(
                FileOutputStream(file),
                Utils.IO_BUFFER_SIZE
            )
            bitmap.compress(mCompressFormat, mCompressQuality, out)
        } finally {
            out?.close()
        }
    }

    companion object {
        private const val TAG = "DiskLruCache"
        private const val CACHE_FILENAME_PREFIX = "cache_"
        private const val MAX_REMOVALS = 4
        private const val INITIAL_CAPACITY = 32
        private const val LOAD_FACTOR = 0.75f

        /**
         * A filename filter to use to identify the cache filenames which have CACHE_FILENAME_PREFIX
         * prepended.
         */
        private val cacheFileFilter =
            FilenameFilter { dir, filename -> filename.startsWith(CACHE_FILENAME_PREFIX) }

        /**
         * Used to fetch an instance of DiskLruCache.
         *
         * @param context
         * @param cacheDir
         * @param maxByteSize
         * @return
         */
        fun openCache(
            context: Context?,
            cacheDir: File,
            maxByteSize: Long
        ): DiskLruCache? {
            if (!cacheDir.exists()) {
                cacheDir.mkdir()
            }
            return if (cacheDir.isDirectory && cacheDir.canWrite()
                && Utils.getUsableSpace(cacheDir) > maxByteSize
            ) {
                DiskLruCache(
                    cacheDir,
                    maxByteSize
                )
            } else null
        }

        /**
         * Removes all disk cache entries from the application cache directory in the uniqueName
         * sub-directory.
         *
         * @param context    The context to use
         * @param uniqueName A unique cache directory name to append to the app cache directory
         */
        fun clearCache(context: Context, uniqueName: String) {
            val cacheDir =
                getDiskCacheDir(
                    context,
                    uniqueName
                )
            clearCache(
                cacheDir
            )
        }

        /**
         * Removes all disk cache entries from the given directory. This should not be called directly,
         * call [DiskLruCache.clearCache] or [DiskLruCache.clearCache]
         * instead.
         *
         * @param cacheDir The directory to remove the cache files from
         */
        private fun clearCache(cacheDir: File) {
            val files =
                cacheDir.listFiles(cacheFileFilter)
            for (i in files.indices) {
                files[i].delete()
            }
        }

        /**
         * Get a usable cache directory (external if available, internal otherwise).
         *
         * @param context    The context to use
         * @param uniqueName A unique directory name to append to the cache dir
         * @return The cache dir
         */
        fun getDiskCacheDir(
            context: Context,
            uniqueName: String
        ): File {
            // Check if media is mounted or storage is built-in, if so, try and use external cache dir
            // otherwise use internal cache dir
            val cachePath =
                if (Environment.getExternalStorageState() === Environment.MEDIA_MOUNTED ||
                    !Utils.isExternalStorageRemovable()
                ) Utils.getExternalCacheDir(context)
                    ?.path else context.cacheDir.path
            return File(cachePath + File.separator + uniqueName)
        }

        /**
         * Creates a constant cache file path given a target cache directory and an image key.
         *
         * @param cacheDir
         * @param key
         * @return
         */
        fun createFilePath(cacheDir: File, key: String): String? {
            try {
                // Use URLEncoder to ensure we have a valid filename, a tad hacky but it will do for
                // this example
                return cacheDir.absolutePath + File.separator +
                        CACHE_FILENAME_PREFIX + URLEncoder.encode(
                    key.replace("*", ""),
                    "UTF-8"
                )
            } catch (e: UnsupportedEncodingException) {
                Log.e(
                    TAG,
                    "createFilePath - $e"
                )
            }
            return null
        }
    }

    /**
     * Constructor that should not be called directly, instead use
     * [DiskLruCache.openCache] which runs some extra checks before
     * creating a DiskLruCache instance.
     *
     * @param cacheDir
     * @param maxByteSize
     */
    init {
        maxCacheByteSize = maxByteSize
    }
}