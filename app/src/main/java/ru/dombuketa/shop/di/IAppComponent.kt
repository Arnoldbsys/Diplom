package ru.dombuketa.shop.di

import dagger.Component
import ru.dombuketa.net_module.IRemoteProvider
import ru.dombuketa.shop.domain.Interactor
import ru.dombuketa.shop.viewmodels.HomeFragmentViewModel
import javax.inject.Singleton

@Singleton
@Component(dependencies = [IRemoteProvider::class], modules = [DomainModule::class])
interface IAppComponent {
    fun inject(homeFragmentViewModel: HomeFragmentViewModel)
    //fun injectt(homeFragment: HomeFragment)

    fun getInteractor() : Interactor




}