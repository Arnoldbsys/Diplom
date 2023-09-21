package ru.dombuketa.shop.views.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.dombuketa.shop.API
import ru.dombuketa.shop.App
import ru.dombuketa.shop.R
import ru.dombuketa.shop.databinding.FragmentHomeBinding
import ru.dombuketa.shop.viewmodels.HomeFragmentViewModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    private val viewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(HomeFragmentViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val thread = Thread {
            //val list = App.instance.netapi.dombuketa2Api.getProduct(350, API.KEY)
            val list = viewModel.getProductModel(350)
            println("fafa")
            list.subscribe(
                {
                    Log.i("FAFA", it.toString())
                    requireActivity().findViewById<TextView>(R.id.texttest).text = it.toString()
                }, Throwable::printStackTrace)

        }
        thread.start()    }



}