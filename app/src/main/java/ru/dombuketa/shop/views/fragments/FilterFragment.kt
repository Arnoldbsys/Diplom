package ru.dombuketa.shop.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.dombuketa.shop.databinding.FragmentFilterBinding
import ru.dombuketa.shop.databinding.FragmentSettingsBinding
import ru.dombuketa.shop.viewmodels.FilterFragmentViewModel


class FilterFragment : Fragment() {
    private lateinit var binding: FragmentFilterBinding

    private val viewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(FilterFragmentViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = FragmentFilterBinding.inflate(inflater, container, false)
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}