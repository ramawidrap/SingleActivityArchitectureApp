package com.sibi.loginapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.sibi.loginapp.R
import com.sibi.loginapp.fragment.BerandaFragment
import com.sibi.loginapp.model.Kategori
import kotlinx.android.synthetic.main.list_kategori.view.*

class KategoriAdapter(val listKategori:List<Kategori>,val navController: NavController,val context:BerandaFragment) : RecyclerView.Adapter<KategoriAdapter.KategoriHolder>() {




    class KategoriHolder(view : View) : RecyclerView.ViewHolder(view) {
        val tvKategoriName = view.tv_kategori
        val imageButton = view.imageButton
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KategoriHolder {
        return KategoriHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_kategori,parent,false));
    }

    override fun getItemCount(): Int {
        return listKategori.size
    }

    override fun onBindViewHolder(holder: KategoriHolder, position: Int) {

        holder.tvKategoriName.text = listKategori[position].nama
        holder.imageButton.setImageResource(listKategori[position].icon)
        holder.imageButton.setOnClickListener {
            val bundle = bundleOf("categoryId" to listKategori[position])
            navController.navigate(R.id.action_dashboardFragment_to_listProductFragment,bundle)

        }

    }

}