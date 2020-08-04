package com.sibi.loginapp.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.sibi.loginapp.R
import com.sibi.loginapp.adapter.AkunAdapter
import com.sibi.loginapp.databinding.FragmentAkunBinding
import com.sibi.loginapp.viewmodel.AkunViewModel
import dagger.android.support.DaggerFragment

import kotlinx.android.synthetic.main.fragment_akun.*
import javax.inject.Inject


class AkunFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory : ViewModelProvider.Factory
    lateinit var viewModel : AkunViewModel

    private lateinit var binding : FragmentAkunBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this,viewModelFactory).get(AkunViewModel::class.java)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_akun,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
        val token = sharedPref.getString("token","")
        viewModel.getUser(token!!).observe(this.viewLifecycleOwner, Observer {
            println("get akun")
            binding.akun =it
        })
        val akunAdapter = AkunAdapter(childFragmentManager)
        viewPager_akun.adapter = akunAdapter
        tabLayout_akun.setupWithViewPager(viewPager_akun)


    }


}
