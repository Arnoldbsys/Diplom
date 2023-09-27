package ru.dombuketa.shop.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product (
    val id: Int,
    val name: String,
    val imageCart: Image?,
    val imageGalary: List<Image?>?,
    val description: String,
    var price: Price?,
    var rating: Double = 0.0,
    var  isInFavorites: Boolean = false
) : Parcelable
