package ru.dombuketa.shop.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import ru.dombuketa.shop.databinding.FragmentFavoritesBinding
import ru.dombuketa.shop.viewmodels.FavoritesFragmentViewModel

class FavoritesFragment : Fragment() {
    private lateinit var binding: FragmentFavoritesBinding

    private val viewModel by lazy {
        ViewModelProvider(this).get(FavoritesFragmentViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}