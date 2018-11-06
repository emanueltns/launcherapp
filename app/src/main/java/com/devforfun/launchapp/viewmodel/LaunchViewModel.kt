package com.devforfun.launchapp.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.devforfun.launchapp.api.LauncherApi
import com.devforfun.launchapp.api.model.LaunchesResponse
import com.devforfun.launchapp.schedulers.BaseSchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject


class LauncherViewModel @Inject constructor(val schedulerProvider: BaseSchedulerProvider,
                                            val launcherApi: LauncherApi) : ViewModel() {

      internal val successHandler = MutableLiveData<LaunchesResponse>()
     internal val errorHandler = MutableLiveData<String>()
    private val subscriptions = CompositeDisposable()

    fun init() {
        subscriptions.add(launcherApi.getNextLaunches(50)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribe(
                {successHandler.postValue(it)},
                {errorHandler.postValue(it.message)},
                { Timber.d("Chains Completed")}
            ))
    }



    fun clear() {
        subscriptions.clear()
    }
}