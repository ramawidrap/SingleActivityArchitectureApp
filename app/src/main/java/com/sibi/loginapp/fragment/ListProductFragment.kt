package com.sibi.loginapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager

import com.sibi.loginapp.R
import com.sibi.loginapp.adapter.ListProductAdapter
import com.sibi.loginapp.model.Kategori
import com.sibi.loginapp.viewmodel.ListProductViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_list_product.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class ListProductFragment : DaggerFragment() {

    fun getCategoryID() : Kategori {
        return requireArguments().getParcelable<Kategori>("categoryId")!!
    }


    @Inject
    lateinit var viewModelFactory : ViewModelProvider.Factory

    private lateinit var argument : Kategori

    private lateinit var navController: NavController

    private lateinit var listProductViewModel: ListProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        navController = requireActivity().findNavController(R.id.fragment)
        // Inflate the layout for this fragment
       argument = requireArguments().getParcelable<Kategori>("categoryId")!!

        listProductViewModel = ViewModelProvider(this,viewModelFactory).get(ListProductViewModel::class.java)
        listProductViewModel.getList().observe(this.viewLifecycleOwner, Observer {
            val adapterListProduct = ListProductAdapter(this.requireContext())
            adapterListProduct.submitList(it)
            rv_list_product.apply {
                layoutManager = GridLayoutManager(this.context,2)
                adapter = adapterListProduct
            }

        })
        return inflater.inflate(R.layout.fragment_list_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar_list_product.setTitle(argument!!.nama)
        toolbar_list_product.setNavigationOnClickListener {
            navController.navigateUp()
        }
    }

}
