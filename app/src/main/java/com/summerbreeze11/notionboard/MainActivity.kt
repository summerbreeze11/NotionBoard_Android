package com.summerbreeze11.notionboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
import com.summerbreeze11.notionboard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnNavigationItemSelectedListener {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()

    }

    private fun init() {
        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            findViewById(R.id.toolbar),
            R.string.open,
            R.string.close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        binding.navView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.id_my_ads -> {
                Toast.makeText(this, "Presed id_my_ads", Toast.LENGTH_LONG).show()
            }
            R.id.id_cer -> {

                Toast.makeText(this, "Presed id_cer", Toast.LENGTH_LONG).show()

            }
            R.id.id_pc -> {

                Toast.makeText(this, "Presed id_pc", Toast.LENGTH_LONG).show()

            }
            R.id.id_smartphones -> {

                Toast.makeText(this, "Presed id_smartphones", Toast.LENGTH_LONG).show()

            }
            R.id.id_home_appliance -> {

                Toast.makeText(this, "Presed id_home_appliance", Toast.LENGTH_LONG).show()

            }
            R.id.id_sign_up -> {

                Toast.makeText(this, "Presed id_sign_up", Toast.LENGTH_LONG).show()

            }
            R.id.id_sign_in -> {

                Toast.makeText(this, "Presed id_sign_in", Toast.LENGTH_LONG).show()

            }
            R.id.id_sign_out -> {

                Toast.makeText(this, "Presed id_sign_out", Toast.LENGTH_LONG).show()

            }
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}