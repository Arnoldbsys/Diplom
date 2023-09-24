package ru.dombuketa.shop.domain

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject
import ru.dombuketa.net_module.IDomBuketa2Api
import ru.dombuketa.shop.API
import ru.dombuketa.shop.converters.ConverterProduct
import ru.dombuketa.shop.models.Product

class Interactor(private val retrofitService: IDomBuketa2Api) {
    var progressBarStateRx : BehaviorSubject<Boolean> = BehaviorSubject.create()


    fun getProductFromAPI(id: Int) : Observable<Product> {
        progressBarStateRx.onNext(true)
        return retrofitService.getProduct(id, API.KEY)
            .subscribeOn(Schedulers.io())
            .map {
                progressBarStateRx.onNext(false)
                ConverterProduct.apiToDTO(it)
            }
            .doOnError { progressBarStateRx.onNext(false) }
    }

    companion object{
        //40*
        private const val TIMEDEVIDER = 60000
        //40*_
    }
}