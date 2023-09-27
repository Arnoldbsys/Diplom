package ru.dombuketa.shop.converters

import ru.dombuketa.net_module.entity.ApiModelImage
import ru.dombuketa.net_module.entity.ApiModelPrice
import ru.dombuketa.net_module.entity.ApiModelProduct
import ru.dombuketa.shop.models.Image
import ru.dombuketa.shop.models.Price
import ru.dombuketa.shop.models.Product

object ConverterPrice {

    fun apiListToDTOList(list: List<ApiModelPrice>?): List<Price?>{
        val result = mutableListOf<Price?>()
        list?.forEach {
            result.add(apiToDTO(it))
        }
        return  result
    }

    fun apiToDTO(price: ApiModelPrice): Price? {
        if (price != null) {
            return Price(
                id = price.id,
                summa = price.summa,
                summaFinal = price.summaFinal,
                discountSumma = price.discountSumma,
                discountPercent = price.discountPercent,
                discountType = price.discountType
            )}
        else return null
    }

}

