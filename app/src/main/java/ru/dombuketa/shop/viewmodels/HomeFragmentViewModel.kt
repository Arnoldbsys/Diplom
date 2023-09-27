package ru.dombuketa.shop.viewmodels

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import ru.dombuketa.shop.App
import ru.dombuketa.shop.domain.Interactor
import ru.dombuketa.shop.models.Product
import ru.dombuketa.shop.utils.SingleLiveEvent
import javax.inject.Inject

class HomeFragmentViewModel : ViewModel() {
    lateinit var productsListRxJavaData : Observable<List<Product>>
    @Inject
    lateinit var interactor: Interactor
    val showProgressBar: BehaviorSubject<Boolean>
    val errorNetworkConnection = SingleLiveEvent<String>() //41*

    init {
        App.instance.dagger.inject(this)
        showProgressBar = interactor.progressBarStateRx
        productsListRxJavaData = interactor.getProductListFromAPIRx(1)
        errorNetworkConnection.postValue("")
    }

    fun getProductList(page: Int) : Observable<List<Product>>{
        return interactor.getProductListFromAPIRx(page)
    }
    companion object{
        const val ERROR_CONNECTION_MSG = "Ошибка соединения." //41*
    }
}

