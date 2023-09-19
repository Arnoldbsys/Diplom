package ru.dombuketa.net_module.entity

import com.google.gson.annotations.SerializedName

data class ApiModelPrice(
    @SerializedName("id")
    val id: Int,
    @SerializedName("сумма")
    val summa: Double,
    @SerializedName("скидкаР")
    val summaFinal: Double,
    @SerializedName("скидкаП")
    val discountSumma: Double,
    @SerializedName("суммаСоСкидкой")
    val discountPercent: Double,
    @SerializedName("тип")
    val discountType: Boolean
)