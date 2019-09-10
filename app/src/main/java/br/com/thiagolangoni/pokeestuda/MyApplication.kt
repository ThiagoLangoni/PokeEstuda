package br.com.thiagolangoni.pokeestuda

import android.app.Application
import br.com.thiagolangoni.pokeestuda.di.networkModule
import br.com.thiagolangoni.pokeestuda.di.repositoryModule
import br.com.thiagolangoni.pokeestuda.di.viewModelModule
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        // Start stetho
        Stetho.initializeWithDefaults(this)
        // Start Koin
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            val modules = modules(
                listOf(
                    viewModelModule,
                    networkModule,
                    repositoryModule
                )
            )
        }
    }
}