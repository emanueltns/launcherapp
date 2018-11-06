package com.devforfun.launchapp.api;

import com.devforfun.launchapp.api.model.LaunchesResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface LauncherApi {

    @GET("launch")
    fun getNextLaunches(@Query("next") numOfLaunch : Int) : Observable<LaunchesResponse>
}