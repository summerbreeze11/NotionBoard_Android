package com.summerbreeze11.notionboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.summerbreeze11.notionboard.activity.EditAdsAct
import com.summerbreeze11.notionboard.databinding.ActivityMainBinding
import com.summerbreeze11.notionboard.dialoghelper.DialogConst
import com.summerbreeze11.notionboard.dialoghelper.DialogHelper
import com.summerbreeze11.notionboard.dialoghelper.GoogleAccConst

class MainActivity : AppCompatActivity(), OnNavigationItemSelectedListener {
    private lateinit var tvAccount: TextView
    private lateinit var binding: ActivityMainBinding
    private val dialogHepler = DialogHelper(this)
    val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.id_new_ads) {
            val intent = Intent(this, EditAdsAct::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == GoogleAccConst.GOOGLE_SIGN_IN_REQUEST_CODE){
            //Log.d("MyLog", "Sign in result")
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try{
                val account = task.getResult(ApiException::class.java)
                if(account != null){
                    dialogHepler.accHelper.signInFirebaseWithGoogle(account.idToken!!)
                }
            } catch(e:ApiException){
                Log.d("MyLog", "Api error ${e.message}")
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onStart() {
        super.onStart()
        uiUpdate(mAuth.currentUser)
    }

    private fun init() {
        setSupportActionBar(binding.mainContent.toolbar)
        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.mainContent.toolbar,
            R.string.open,
            R.string.close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        binding.navView.setNavigationItemSelectedListener(this)

        tvAccount = binding.navView.getHeaderView(0).findViewById(R.id.tvAccountEmail)
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

                dialogHepler.createSignDialog(DialogConst.SIGN_UP_STATE)

            }
            R.id.id_sign_in -> {

                dialogHepler.createSignDialog(DialogConst.SIGN_IN_STATE)

            }
            R.id.id_sign_out -> {

                uiUpdate(null)
                mAuth.signOut()
                dialogHepler.accHelper.signOutGoogle()
            }
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    fun uiUpdate(user: FirebaseUser?) {
        tvAccount.text = if(user == null){
            resources.getString(R.string.not_reg)
        } else {
            user.email
        }
    }
}