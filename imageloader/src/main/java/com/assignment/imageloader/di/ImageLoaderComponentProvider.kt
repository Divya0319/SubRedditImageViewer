package com.assignment.imageloader.di

import com.assignment.imageloader.di.ImageLoaderComponent

/**
 * Created by Divya Gupta.
 */
interface ImageLoaderComponentProvider {
    fun provideImageLoaderComponent(): ImageLoaderComponent
}