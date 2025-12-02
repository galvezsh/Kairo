package com.galvezsh.kairo

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class KairoApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        // Here is where Koin is initialized
        startKoin {
            // Log Koin into Android logger
            androidLogger()

            // Reference Android context
            androidContext( androidContext = this@KairoApplication )

            // Load modules
            modules( /* Load the modules here */ )
        }
    }
}