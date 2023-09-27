package ru.dombuketa.shop.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import ru.dombuketa.shop.R
import ru.dombuketa.shop.databinding.ActivityMainBinding
import ru.dombuketa.shop.models.Product
import ru.dombuketa.shop.views.fragments.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNavMenu()
//        val fragmentDetailsTovar = checkFragExist("details_tovar")
//        changeFrag(fragmentDetailsTovar ?: DetailsTovarFragment(), "details_tovar")

//        val fragmentHome = checkFragExist("home")
//        changeFrag(fragmentHome ?: HomeFragment(), "home")

        val fragmentFavorites = checkFragExist("fav")
        changeFrag(fragmentFavorites ?: FavoritesFragment(), "fav")

    }



    fun initNavMenu(){
        binding.bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.nav_nemu_home -> {
                    val tag = "home"
                    val fragment = checkFragExist(tag)
                    changeFrag(fragment?: HomeFragment(), tag)
                    true
                }
                R.id.nav_nemu_favorites ->{
                    val tag = "fav"
                    val fragment = checkFragExist(tag)
                    changeFrag(fragment?:FavoritesFragment(), tag)
                    true
                }
                R.id.nav_nemu_filter ->{
                    val tag = "filter"
                    val fragment = checkFragExist(tag)
                    changeFrag(fragment?: FilterFragment(), tag)
                    true
                }
                R.id.nav_nemu_shopping_cart ->{
                    val tag = "shoppingcart"
                    val fragment = checkFragExist(tag)
                    changeFrag(fragment?: ShoppingCartFragment(), tag)
                    true
                }
                R.id.nav_nemu_settings ->{
                    val tag = "settings"
                    val fragment = checkFragExist(tag)
                    changeFrag(fragment?: SettingsFragment(), tag)
                    true
                }
                else -> false
            }
        }
    }

    private fun checkFragExist(tag: String): Fragment? {
        return supportFragmentManager.findFragmentByTag(tag)
    }

    private fun changeFrag(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_placeholder, fragment, tag)
            .addToBackStack(null).commit()
    }

    fun lanunchDetailsFragment(product: Product){
        //Создаем "посылку"
        val bundle = Bundle()
        //Кладем наш фильм в "посылку"
        bundle.putParcelable("film",product)
        //Кладем фрагмент с деталями в перменную
        val fragment = DetailsTovarFragment()
        //Прикрепляем нашу "посылку" к фрагменту
        fragment.arguments = bundle
        //Запускаем фрагмент
        supportFragmentManager
            .beginTransaction().replace(R.id.fragment_placeholder, fragment)
            .addToBackStack(null).commit()
    }
}