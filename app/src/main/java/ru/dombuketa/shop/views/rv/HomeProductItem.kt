package ru.dombuketa.shop.views.rv

import android.view.View
import com.bumptech.glide.Glide
import com.xwray.groupie.viewbinding.BindableItem
import ru.dombuketa.shop.R
import ru.dombuketa.shop.databinding.ItemTovarHBinding
import ru.dombuketa.shop.models.Product

class HomeProductItem(private val content: Product) : BindableItem<ItemTovarHBinding>() {
    override fun getLayout(): Int {
        return R.layout.item_tovar_h
    }

    override fun bind(binding: ItemTovarHBinding, position: Int) {
        binding.title.text = content.name

        if (content.imageCart != null) {
            Glide.with(binding.root.context)
                .load(ru.dombuketa.net_module.entity.ApiConstants.IMAGES_URL + content.imageCart.path + content.imageCart.fileName)
                .centerCrop()
                .into(binding.poster)
        }

    }

    override fun initializeViewBinding(view: View): ItemTovarHBinding {
        return ItemTovarHBinding.bind(view)
    }
}