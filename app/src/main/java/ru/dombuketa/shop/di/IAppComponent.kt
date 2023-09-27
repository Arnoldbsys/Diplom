package ru.dombuketa.shop.di

import dagger.Component
import ru.dombuketa.net_module.IRemoteProvider
import ru.dombuketa.shop.domain.Interactor
import ru.dombuketa.shop.viewmodels.DetailsTovarFragmentViewModel
import ru.dombuketa.shop.viewmodels.FavoritesFragmentViewModel
import ru.dombuketa.shop.viewmodels.HomeFragmentViewModel
import javax.inject.Singleton

@Singleton
@Component(dependencies = [IRemoteProvider::class], modules = [DomainModule::class])
interface IAppComponent {
    fun inject(homeFragmentViewModel: HomeFragmentViewModel)
    fun inject(favoritesFragmentViewModel: FavoritesFragmentViewModel)
    fun inject(detailsTovarFragmentViewModel: DetailsTovarFragmentViewModel)
    //fun injectt(homeFragment: HomeFragment)

    fun getInteractor() : Interactor




}