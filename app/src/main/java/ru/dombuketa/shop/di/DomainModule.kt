package ru.dombuketa.shop.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.dombuketa.shop.domain.Interactor
import javax.inject.Singleton

@Module
//Передаем контекст для SharedPreferences через конструктор
class DomainModule(val context: Context) {
    //Нам нужно контекст как-то провайдить, поэтому создаем такой метод
    @Provides
    fun  provideContext() = context

    @Singleton
    @Provides
    fun provideInteractor(domBuketaApi2: ru.dombuketa.net_module.IDomBuketa2Api) =
        Interactor(retrofitService = domBuketaApi2)
}