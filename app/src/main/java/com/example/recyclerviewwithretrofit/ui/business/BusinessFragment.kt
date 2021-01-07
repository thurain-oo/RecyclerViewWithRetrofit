package com.example.recyclerviewwithretrofit.ui.business

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.recyclerviewwithretrofit.Adapters.BusinessAdapter
import com.example.recyclerviewwithretrofit.databinding.FragmentBusinessBinding


class BusinessFragment : Fragment() {

    private lateinit var businessViewModel: BusinessViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        businessViewModel =
                ViewModelProvider(this).get(BusinessViewModel::class.java)

        val binding = FragmentBusinessBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.business=        businessViewModel

        binding.recyclerView.adapter = BusinessAdapter()

//        businessViewModel.articles.observe(viewLifecycleOwner, Observer {
//           var adapter = BusinessAdapter(
//               BusinessFragment(),it)
//
//              binding.recyclerView.adapter = adapter
//
//
//        })
        return binding.root
    }
}