package ru.dombuketa.shop.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Price (
    val id: Int,
    val summa: Double = 0.0,
    val summaFinal: Double = 0.0,
    val discountSumma: Double = 0.0,
    val discountPercent: Double = 0.0,
    val discountType: Boolean = true
) : Parcelable
