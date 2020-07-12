package com.assignment.imageloader.di

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Divya Gupta.
 */

/**
 * Dagger App module class created to provide imageloader-module-level dependencies
 */
@Module
class ImageLoaderModule(private val context: Context) {
    @Provides
    @Singleton
    internal fun provideContext(): Context {
        return context
    }
}