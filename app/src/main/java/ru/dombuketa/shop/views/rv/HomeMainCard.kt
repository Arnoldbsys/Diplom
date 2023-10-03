package ru.dombuketa.shop.views.rv

import android.view.View
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.viewbinding.BindableItem
import ru.dombuketa.shop.R
import ru.dombuketa.shop.databinding.ItemTovarHBinding
import ru.dombuketa.shop.databinding.RvHomeItemMainBinding
import ru.dombuketa.shop.models.Category

class HomeMainCard(
   private val title: String? = "",
   private val description: String? = "",
   private val onClick: (url: String) -> Unit,
   private val items: List<BindableItem<*>>) : BindableItem<RvHomeItemMainBinding>() {

   override fun bind(binding: RvHomeItemMainBinding, position: Int) {
      binding.title.text = title
      binding.description.text = description
      binding.itemsContainer.adapter = GroupieAdapter().apply { addAll(items) }
   }

   override fun getLayout(): Int {
      return R.layout.rv_home_item_main
   }

   override fun initializeViewBinding(view: View): RvHomeItemMainBinding {
      return RvHomeItemMainBinding.bind(view)
   }

}