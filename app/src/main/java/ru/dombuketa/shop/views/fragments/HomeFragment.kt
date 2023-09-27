package ru.dombuketa.shop.views.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.ObservableOnSubscribe
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.dombuketa.filmslocaror.view.rv_adapters.ProductListRecyclerAdapter
import ru.dombuketa.shop.API
import ru.dombuketa.shop.App
import ru.dombuketa.shop.R
import ru.dombuketa.shop.databinding.FragmentHomeBinding
import ru.dombuketa.shop.models.Product
import ru.dombuketa.shop.utils.AutoDisposable
import ru.dombuketa.shop.utils.addTo
import ru.dombuketa.shop.viewmodels.HomeFragmentViewModel
import ru.dombuketa.shop.views.MainActivity

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var productAdapter: ProductListRecyclerAdapter
    private val autoDisposable = AutoDisposable()

    private val viewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(HomeFragmentViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        autoDisposable.bindTo(lifecycle)
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.showProgressBar.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                binding.progressBar.isVisible = it
            }
        initRV()

        viewModel.productsListRxJavaData
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( {
                Log.i("FAFA", it.count().toString())
                productAdapter.addItems(it)
                binding.testtst.text = it.count().toString()
                //filmsDataBase = list
            }, Throwable::printStackTrace)
            .addTo(autoDisposable)
    }

    private fun initRV() {
        binding.mainRecycler.apply {
            productAdapter =
                ProductListRecyclerAdapter(object : ProductListRecyclerAdapter.OnItemClickListener {
                    override fun click(product: Product) {
                        (requireActivity() as MainActivity).lanunchDetailsFragment(product)
                    }
                })
            //Присваиваем адаптер
            adapter = productAdapter
            //Присвои layoutmanager
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

            //layoutManagerRV = layoutManager as LinearLayoutManager
            //Применяем декоратор для отступов
            //val decorator = TopSpacingItemDecoration(8)
            //addItemDecoration(decorator)
            binding.testtst.text = "initRV"
        }
        initRvScroller()
    }

    private fun initRvScroller() {
//        io.reactivex.rxjava3.core.Observable.create(ObservableOnSubscribe<Int> { page ->
//            binding.mainRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//                    super.onScrollStateChanged(recyclerView, newState)
//                }
//                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                    super.onScrolled(recyclerView, dx, dy)
//                    if (dy > 0 && layoutManagerRV.findLastVisibleItemPosition() > lastVisibleItem) { // Прокрутка вниз.
//                        lastVisibleItem = layoutManagerRV.findLastVisibleItemPosition()
//                        Log.i("initRvScroller","!!!  totalItemCount=${layoutManagerRV.itemCount} lastVisiblesItems=$lastVisibleItem pageNumber=$pageNumber")
//                        if (lastVisibleItem + FILMS_ITEM_SHIFT == FILMS_PER_PAGE * pageNumber - 1) {
//                            page.onNext(++pageNumber); // viewModel.getFilms(++pageNumber) Сейчас передаем по потоку
//                        }
//                    }
//                }
//            })
//        })
//            .observeOn(Schedulers.io())
//            .subscribeBy(
//                onNext = {
//                    val query = binding.searchView.getQuery().toString().trim()
//                    if (query.isNotBlank()) {
//                        viewModel.getFilmsBySearch(query, it)
//                            .subscribeOn(Schedulers.io())
//                            .observeOn(AndroidSchedulers.mainThread())
//                            .subscribeBy(
//                                onNext = {
//                                    filmsAdapter.addItems(it)
//                                },
//                                onError = {
//                                    Toast.makeText(requireContext(),"Ошибка загрузки данных из сети.", Toast.LENGTH_SHORT).show()
//                                    it.message?.let { it1 -> Log.e("subscribe 1", it1) }
//                                })
//                    } else {
//                        viewModel.getFilms(it)
//                    }
//                },
//                onError = {
//                    Toast.makeText(
//                        requireContext(),
//                        "Ошибка загрузки данных из сети.",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                    it.message?.let { it1 -> Log.e("subscribe 2", it1) }
//                })
    }

    companion object {
        const val FILMS_ITEM_SHIFT: Int = 4
        const val FILMS_PER_PAGE: Int = 20
    }

}