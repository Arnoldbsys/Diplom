package ru.dombuketa.net_module

import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.dombuketa.net_module.entity.ApiModelProduct
import ru.dombuketa.net_module.entity.ApiProduct_ResultsDTO

interface IDomBuketa2Api {
    @GET("2/product/item/{id}")
    fun getProduct(
        @Path("id") category: Int,
        @Query("key") apiKey: String,
    ): Observable<ApiModelProduct>
    @GET("2/product/category/{category}")
    fun getProductList(
        @Path("category") category: String,
        @Query("key") apiKey: String,
        @Query("page") page: Int,
    ): Observable<ApiProduct_ResultsDTO>
    // Поиск
    @GET("2/product/searchbyname/{query}")
    fun getProductListSearchByName(
        @Path("query") category: String,
        @Query("key") apiKey: String,
        @Query("page") page: Int
    ): Observable<ApiProduct_ResultsDTO>
}

