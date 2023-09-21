package ru.dombuketa.shop.converters

import ru.dombuketa.net_module.entity.ApiModelProduct
import ru.dombuketa.shop.models.Product

object ConverterProduct {

    fun convertApiListToDTOList(list: List<ApiModelProduct>?): List<Product>{
        val result = mutableListOf<Product>()
        list?.forEach {
            result.add(convertApiProductToDTOProduct(it))
        }
        return  result
    }

    fun convertApiProductToDTOProduct(product: ApiModelProduct): Product {
        return Product(
            id = product.id,
            name =  product.name,
            imageCart = product.imageCart.fileName,
            imageGalary = product.imageGalary[0].fileName,
            description = product.description,
            price = product.price.summaFinal,
            rating = 0.0,
            isInFavorites = false
        )
    }

}

