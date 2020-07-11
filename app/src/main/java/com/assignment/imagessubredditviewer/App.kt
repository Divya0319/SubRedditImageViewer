package com.assignment.imagessubredditviewer

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Bundle
import com.assignment.imagessubredditviewer.di.AppComponent
import com.assignment.imagessubredditviewer.di.AppModule
import com.assignment.imagessubredditviewer.di.DaggerAppComponent
import com.assignment.imagessubredditviewer.di.UtilsModule

/**
 * Created by Divya Gupta.
 */
class App : Application() {
    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        context = this.applicationContext

        /**
         * Dagger app component builder for building necessary dependencies at compile time itself
         */
        appComponent =
            DaggerAppComponent.builder().appModule(AppModule(this.applicationContext)).utilsModule(
                UtilsModule()
            ).build()


        registerActivityLifecycleCallbacks(object :
            ActivityLifecycleCallbacks {
            override fun onActivityPaused(activity: Activity?) {
            }

            override fun onActivityResumed(activity: Activity?) {
            }

            override fun onActivityStarted(activity: Activity?) {
            }

            override fun onActivityDestroyed(activity: Activity?) {
            }

            override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
            }

            override fun onActivityStopped(activity: Activity?) {
            }

            override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
                activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            }
        })

    }

    companion object {
        var context: Context? = null
            private set
    }
}