package com.devforfun.launchapp.di;

import com.devforfun.launchapp.LauncherApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidSupportInjectionModule::class,
    AppModule::class, ViewModelBuilder::class, ActivityBuilder::class))
interface AppComponent : AndroidInjector<LauncherApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<LauncherApplication>()
}