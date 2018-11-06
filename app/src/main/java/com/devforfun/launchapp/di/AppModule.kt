package com.devforfun.launchapp.di;

import android.content.Context
import com.devforfun.launchapp.LauncherApplication
import com.devforfun.launchapp.schedulers.BaseSchedulerProvider
import com.devforfun.launchapp.schedulers.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module(includes = arrayOf(NetworkModule::class))
class AppModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        internal fun providesScheduler(scheduler : SchedulerProvider)
                : BaseSchedulerProvider {
            return scheduler
        }
    }

    @Provides
    fun providesContext(application: LauncherApplication): Context {
        return application.applicationContext
    }
}