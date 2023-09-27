package ru.dombuketa.shop.viewmodels

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import ru.dombuketa.shop.App
import ru.dombuketa.shop.domain.Interactor
import ru.dombuketa.shop.models.Product
import ru.dombuketa.shop.utils.SingleLiveEvent
import javax.inject.Inject

class DetailsTovarFragmentViewModel : ViewModel() {
    lateinit var productDetails: Observable<Product>
    @Inject
    lateinit var interactor: Interactor
    val showProgressBar: BehaviorSubject<Boolean>
    val errorNetworkConnection = SingleLiveEvent<String>() //41*

    init {
        App.instance.dagger.inject(this)
        showProgressBar = interactor.progressBarStateRx
        errorNetworkConnection.postValue("")
    }

    fun getProductModel(id: Int) : Observable<Product> {
        return interactor.getProductFromAPI(id)
    }

    companion object{
        const val ERROR_CONNECTION_MSG = "Ошибка соединения." //41*
    }
}