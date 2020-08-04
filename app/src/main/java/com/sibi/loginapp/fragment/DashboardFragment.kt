package com.sibi.loginapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView

import com.sibi.loginapp.R
import kotlinx.android.synthetic.main.fragment_dashboard.*

/**
 * A simple [Fragment] subclass.
 */
class DashboardFragment : Fragment() {

    var dashboardView: View? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardView = view
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.navHost_dashboard) as NavHostFragment
        navHostFragment.navController.addOnDestinationChangedListener { controller, destination, arguments -> if(destination.id == R.id.navigation_akun || destination.id == R.id.navigation_myProduct){
            println("wkwkkw")
            toolbar.visibility = View.GONE
        }
            else {
            toolbar.visibility =View.VISIBLE
        }
        }
        NavigationUI.setupWithNavController(bmnav, navHostFragment.navController)

    }

}
