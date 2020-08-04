package com.sibi.loginapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager

import com.sibi.loginapp.R
import com.sibi.loginapp.adapter.KategoriAdapter
import com.sibi.loginapp.databinding.FragmentLoginBinding
import com.sibi.loginapp.model.Kategori
import dagger.Module
import dagger.Provides
import dagger.android.DaggerFragment
import kotlinx.android.synthetic.main.fragment_beranda.*
import javax.inject.Qualifier

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private var ID =""

/**
 * A simple [Fragment] subclass.
 * Use the [BerandaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BerandaFragment : Fragment() {

//    @Qualifier
//    @MustBeDocumented
//    @Retention(AnnotationRetention.RUNTIME)
//    annotation class categoryId{}
//
//    @categoryId
//    var id = BerandaFragment.id
//
//    @Module
//    abstract class categoryIdModule {
//        @Provides
//        @BerandaFragment.categoryId
//        fun categoryId(berandaFragment: BerandaFragment) : String{
//            return BerandaFragment.id
//        }
//    }
    var view = null



    private val listKategori = listOf<Kategori>(
        Kategori("Makanan", R.drawable.ic_kategori_makanan,"category-1"),
        Kategori("Minuman", R.drawable.ic_kategori_minuman,"category-2"),
        Kategori("Hasil Alam", R.drawable.ic_kategori_hasil_alam,"category-3"),
        Kategori("Pakaian", R.drawable.ic_kategori_pakaian,"category-4"),
        Kategori("Interior Rumah",R.drawable.ic_kategori_interior,"category-5"),
        Kategori("Kesehatan",R.drawable.ic_kategori_kesehatan,"category-6"),
        Kategori("Jasa",R.drawable.ic_kategori_jasa,"category-7"),
        Kategori("Lainnya",R.drawable.ic_lainnya,"category-8")
    )

    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentLoginBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_login, container, false)

        return inflater.inflate(R.layout.fragment_beranda, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = requireActivity().findNavController(R.id.fragment)
        println("parent fragment ${navController.currentDestination}")
        val kategoriAdapter = KategoriAdapter(listKategori,navController,this)

        rv_kategori.apply {
            layoutManager = GridLayoutManager(this.context, 4)
            adapter = kategoriAdapter
        }


    }
    companion object {
        var id = ""
    }

}
