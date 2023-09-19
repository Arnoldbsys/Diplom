package ru.dombuketa.net_module.entity

import com.google.gson.annotations.SerializedName

data class ApiModelProduct(
    @SerializedName("id")
    val id: Int,
    @SerializedName("Name")
    val name: String,
    @SerializedName("imageCart")
    val imageCart: ApiModelImage,
    @SerializedName("imageGalary")
    val imageGalary: List<ApiModelImage>,
    @SerializedName("descriptionShort")
    val description: String,

    @SerializedName("price")
    val price: ApiModelPrice,
    @SerializedName("rating")
    val rating: Double,
)