package com.adrena.basearchitect

import android.app.Application
import com.adrena.basearchitect.core.internal.networkModule
import com.adrena.basearchitect.core.preferences.preferencesModule
import com.adrena.basearchitect.features.flows.users.module.usersModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class BaseArchitectApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.INFO)
            androidContext(this@BaseArchitectApplication)
            koin.loadModules(
                listOf(
                    preferencesModule,
                    networkModule,
                    usersModule
                )
            )
        }
    }
}