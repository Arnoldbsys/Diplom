package ru.dombuketa.filmslocaror.view.rv_viewholders

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.dombuketa.shop.databinding.ItemTovarHBinding
import ru.dombuketa.shop.databinding.ItemTovarVBinding
import ru.dombuketa.shop.models.Product


class ProductViewHolder(var binding: ItemTovarVBinding) : RecyclerView.ViewHolder(binding.root) {
    //Привязываем View из layout к переменным
    //В этом методе кладем данные из Film в наши View
    fun bind(tovar: Product){
        binding.tovar = tovar
        if (tovar.imageCart != null) {
            Glide.with(itemView)
                .load(ru.dombuketa.net_module.entity.ApiConstants.IMAGES_URL + tovar.imageCart.path + tovar.imageCart.fileName)
                .centerCrop()
                .into(binding.poster)
        }
    }
}

