package com.assignment.imagessubredditviewer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.assignment.imagessubredditviewer.network.ApiResponse
import com.assignment.imagessubredditviewer.network.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Divya Gupta.
 */

class MainActivityViewModel internal constructor(private val repository: Repository) : ViewModel() {
    private val disposable = CompositeDisposable()
    private val responseImagesAPI = MutableLiveData<ApiResponse>()
    val imagesAPIResponse: LiveData<ApiResponse> get() = responseImagesAPI

    fun hitImagesApi() {
        disposable.add(repository.executeImagesApiCall()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { responseImagesAPI.value = ApiResponse.loading() }
            .subscribe(
                { result -> responseImagesAPI.value = ApiResponse.success(result) },
                { error -> responseImagesAPI.value = ApiResponse.error(error) }
            ))
    }

    override fun onCleared() {
        disposable.clear()
    }
}