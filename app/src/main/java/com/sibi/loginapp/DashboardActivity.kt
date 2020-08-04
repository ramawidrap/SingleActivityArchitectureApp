package com.sibi.loginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_dashboard.*
import javax.inject.Inject

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHost_dashboard)  as NavHostFragment
//        NavigationUI.setupWithNavController(bmnav,navHostFragment.navController)

    }
}
