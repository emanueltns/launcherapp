package com.devforfun.launchapp.di;

import android.arch.lifecycle.ViewModel
import com.devforfun.launchapp.ui.DetailsActivity
import com.devforfun.launchapp.ui.MainActivity
import com.devforfun.launchapp.viewmodel.LauncherViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun details(): DetailsActivity

    @Binds
    @IntoMap
    @ViewModelKey(LauncherViewModel::class)
    abstract fun bindMainViewModel(viewModel: LauncherViewModel): ViewModel
}