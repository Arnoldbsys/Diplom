package ru.dombuketa.shop.views.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.dombuketa.shop.databinding.FragmentDetailsTovarBinding
import ru.dombuketa.shop.viewmodels.DetailsTovarFragmentViewModel

class DetailsTovarFragment : Fragment() {
    private lateinit var binding: FragmentDetailsTovarBinding

    private val viewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(DetailsTovarFragmentViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetailsTovarBinding.inflate(inflater, container, false)
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel.getProductModel(350).subscribe(
//            {
//                Log.i("FAFA", it.toString())
//                binding.detailsDescription.text = it.toString()
//            }, Throwable::printStackTrace
//        )

        viewModel.productDetails.subscribe(
            {
                Log.i("FAFA", it.toString())
                binding.detailsDescription.text = it.toString()
            }, Throwable::printStackTrace
        )


    }

}