package com.sibi.loginapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.sibi.loginapp.fragment.PembeliFragment
import com.sibi.loginapp.fragment.TokoUmkmFragment

class AkunAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> return PembeliFragment()
            else -> return TokoUmkmFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> return "Pembeli"
            else -> return "Toko UMKM"
        }
    }
}