package com.sibi.loginapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sibi.loginapp.R
import com.sibi.loginapp.model.Product
import kotlinx.android.synthetic.main.list_product.view.*

class ListProductAdapter(private val context : Context) : PagedListAdapter<Product,ListProductAdapter.listProductViewHolder>(Product.CALLBACK) {
    class listProductViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val imageProduct = itemView.iv_product
        val titleProduct = itemView.tv_title
        val priceProduct = itemView.tv_harga

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): listProductViewHolder {
        return listProductViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_product,parent,false))
    }

    override fun onBindViewHolder(holder: listProductViewHolder, position: Int) {
        val product = getItem(position)
        Glide.with(context).load(product!!.images[0]).error(R.drawable.ic_logo).placeholder(R.drawable.ic_logo).into(holder.imageProduct)
        holder.titleProduct.text = product.name
        holder.priceProduct.text = product.pricePerQuantity.toString()
    }



}
