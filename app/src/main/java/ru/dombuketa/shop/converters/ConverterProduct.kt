package ru.dombuketa.shop.converters

import ru.dombuketa.net_module.entity.ApiModelProduct
import ru.dombuketa.shop.models.Product

object ConverterProduct {

    fun apiListToDTOList(list: List<ApiModelProduct>?): List<Product>{
        val result = mutableListOf<Product>()
        list?.forEach {
            result.add(apiToDTO(it))
        }
        return  result
    }

    fun apiToDTO(product: ApiModelProduct): Product {
        return Product(
            id = product.id,
            name =  product.name,
            imageCart = if (product.imageCart == null) null else ConverterImage.apiToDTO(product.imageCart),
            imageGalary = ConverterImage.apiListToDTOList(product.imageGalary),
            description = product.description,
            price = if (product.price == null) null else ConverterPrice.apiToDTO(product.price),
            rating = 0.0,
            isInFavorites = false
        )
    }

}

