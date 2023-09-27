package ru.dombuketa.net_module.entity

import com.google.gson.annotations.SerializedName

data class ApiProduct_ResultsDTO (
    @SerializedName("page")
    val page: Int,
    @SerializedName("result")
    val productList: List<ApiModelProduct>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)
