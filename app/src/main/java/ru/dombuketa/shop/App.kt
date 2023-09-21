package ru.dombuketa.shop

import android.app.Application
import ru.dombuketa.net_module.DaggerIRemoteComponent
import ru.dombuketa.shop.di.DaggerIAppComponent
import ru.dombuketa.shop.di.DomainModule
import ru.dombuketa.shop.di.IAppComponent

class App : Application()
{
    lateinit var dagger : IAppComponent
    //val netapi = Net()


    override fun onCreate() {
        super.onCreate()
        instance = this

        dagger = DaggerIAppComponent.builder()
            .domainModule(DomainModule(this))
            .iRemoteProvider(DaggerIRemoteComponent.create())
            .build()


    }

    companion object{
        lateinit var instance: App
        //Приватный сеттер, чтобы нельзя было в эту переменную присвоить что-либо другое
        private set
    }

}