package ru.dombuketa.shop.converters

import ru.dombuketa.net_module.entity.ApiModelImage
import ru.dombuketa.net_module.entity.ApiModelProduct
import ru.dombuketa.shop.models.Image
import ru.dombuketa.shop.models.Product

object ConverterImage {

    fun apiListToDTOList(list: List<ApiModelImage>?): List<Image?>?{
        val result = mutableListOf<Image?>()
//        if (list != null) {
            list?.forEach {
                result.add(apiToDTO(it))
            }
            return result
//        } else return null
    }

    fun apiToDTO(image: ApiModelImage): Image? {
        if (image != null){
        return Image(
            id = image.id,
            path =  image.path.replace("\\","/") + "/",
            fileName = image.fileName
        )}
        else return null
    }

}

