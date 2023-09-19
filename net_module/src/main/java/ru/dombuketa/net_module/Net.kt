package ru.dombuketa.net_module

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Net {

    val okHttpClient = OkHttpClient.Builder()
        .callTimeout(NETWORKTIMEOUT, TimeUnit.SECONDS)
        .readTimeout(NETWORKTIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(NETWORKTIMEOUT, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }).build()

    val retrofit = Retrofit.Builder()
        .baseUrl(ru.dombuketa.net_module.entity.ApiConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .client(okHttpClient).build()

    val dombuketa2Api : IDomBuketa2Api = retrofit.create(IDomBuketa2Api::class.java)

    companion object{
        //Здесь статически хранится ссылка на экземпляр Net
        lateinit var instance: Net
            //Приватный сеттер, чтобы нельзя было в эту переменную присвоить что-либо другое
            private set
        const val NETWORKTIMEOUT = 60L
    }
}