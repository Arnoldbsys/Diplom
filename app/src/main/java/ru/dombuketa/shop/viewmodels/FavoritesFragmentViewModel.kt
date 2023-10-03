package ru.dombuketa.shop.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.subjects.AsyncSubject
import io.reactivex.rxjava3.subjects.BehaviorSubject
import org.reactivestreams.Subscriber
import ru.dombuketa.shop.App
import ru.dombuketa.shop.domain.Interactor
import ru.dombuketa.shop.models.Product
import ru.dombuketa.shop.utils.SingleLiveEvent
import ru.dombuketa.shop.views.fragments.FavoritesFragment
import javax.inject.Inject

class FavoritesFragmentViewModel : ViewModel() {
    lateinit var productsListRxJavaData : Observable<List<Product>>
    lateinit var productsListRx : AsyncSubject<List<Product>>
    lateinit var testObs : Observable<Int>
    @Inject
    lateinit var interactor: Interactor
    val showProgressBar: BehaviorSubject<Boolean>
    val errorNetworkConnection = SingleLiveEvent<String>() //41*

    init {
        App.instance.dagger.inject(this)
        showProgressBar = interactor.progressBarStateRx
        //QRx Первоначальое получение данных
        productsListRxJavaData = interactor.getProductListFromAPIRx(1)

        errorNetworkConnection.postValue("")


        testObs = Observable.create() { emi ->
            emi.onNext(1
//                FavoritesFragment.clickWrapper.map {
//                   Single.just(it.id)
//                }

                )
        }
        //QRx подписка на скроллинт RecyclerView в фрагменте
        val d = FavoritesFragment.scrollerInfo.subscribe( {
            Log.i("scrollerInfo", "scroll $it")
            //QRx отправляю вторую страницу и она получена. Здесь вопрос, почему Вью ее не видит
            productsListRxJavaData = interactor.getProductListFromAPIRx(it)
            errorNetworkConnection.postValue("")
            },
            {
                println("Error:")
            },
            {
                println("Completed: scrollerInfo")
            })

        val d2 = FavoritesFragment.clickWrapper.subscribe( {
                Log.i("clickWrapper", "click $it")
                testObs = Observable.just(it.id)


            },
            { println("Error:") },
            { println("Completed: clickWrapper")})



    }

    fun getProductList(page: Int) : Observable<List<Product>> {
        return interactor.getProductListFromAPIRx(page)
    }
    companion object{
        const val ERROR_CONNECTION_MSG = "Ошибка соединения." //41*
    }

}