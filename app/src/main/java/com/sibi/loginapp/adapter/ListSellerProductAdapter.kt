package com.sibi.loginapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sibi.loginapp.R
import com.sibi.loginapp.databinding.ListMyProductBinding
import com.sibi.loginapp.model.Product
import kotlinx.android.synthetic.main.list_my_product.view.*

class ListSellerProductAdapter() :
    PagedListAdapter<Product, ListSellerProductAdapter.viewHolder>(Product.CALLBACK) {
    class viewHolder(val bindingView: ListMyProductBinding) : RecyclerView.ViewHolder(bindingView.root) {
        val bind = bindingView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.list_my_product,parent,false))
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.bind.product = getItem(position)
    }
}