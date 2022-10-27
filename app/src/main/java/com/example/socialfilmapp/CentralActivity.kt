package com.example.socialfilmapp

import android.content.ClipData
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.socialfilmapp.databinding.ActivityCentralBinding

class CentralActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCentralBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCentralBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarCentral.toolbar)
        binding.appBarCentral.toolbar

        val navView: BottomNavigationView = binding.navView





        val navController = findNavController(R.id.nav_host_fragment_activity_central)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.action_bar_menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.Setting_menu -> {
                startActivity(Intent(this,HomeActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}