package com.sibi.loginapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager

import com.sibi.loginapp.R
import com.sibi.loginapp.adapter.ListSellerProductAdapter
import com.sibi.loginapp.viewmodel.ListProductSellerViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_my_product.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class MyProductFragment : DaggerFragment() {

    @Inject lateinit var viewModelFactory : ViewModelProvider.Factory

    lateinit var viewModel : ListProductSellerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this,viewModelFactory).get(ListProductSellerViewModel::class.java)

        return inflater.inflate(R.layout.fragment_my_product, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getList().observe(this.viewLifecycleOwner, Observer {
            val listSellerProductAdapter = ListSellerProductAdapter()
            listSellerProductAdapter.submitList(it)
            rv_list_myProduct.apply {
                layoutManager = LinearLayoutManager(this.context)
                adapter = listSellerProductAdapter
            }
        })
    }

}
