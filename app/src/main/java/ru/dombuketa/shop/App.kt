package ru.dombuketa.shop

import android.app.Application
import ru.dombuketa.net_module.Net

class App : Application()
{

    val netapi = Net()

    override fun onCreate() {
        super.onCreate()
        instance = this




    }

    companion object{
        lateinit var instance: App
        //Приватный сеттер, чтобы нельзя было в эту переменную присвоить что-либо другое
        private set
    }

}