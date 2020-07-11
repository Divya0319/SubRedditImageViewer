package com.assignment.imagessubredditviewer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.assignment.imagessubredditviewer.network.Repository
import javax.inject.Inject

/**
 * Created by Divya Gupta.
 */
@Suppress("UNCHECKED_CAST")
class MainActivityVMFactory @Inject constructor(private val repository: Repository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityVMFactory(repository) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}