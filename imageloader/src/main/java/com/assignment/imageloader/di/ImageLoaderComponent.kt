package com.assignment.imageloader.di

import com.assignment.imageloader.cachemanagement.ImagesCache
import dagger.Component

/**
 * Created by Divya Gupta.
 */

@Component(modules = [ImageLoaderModule::class])
interface ImageLoaderComponent {
    fun doInjection(imagesCache: ImagesCache)
}