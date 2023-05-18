package com.summerbreeze11.notionboard.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.summerbreeze11.notionboard.databinding.ActivityEditAdsBinding
import com.summerbreeze11.notionboard.dialogs.DialogSpinerHelper
import com.summerbreeze11.notionboard.utils.CityHepler

class EditAdsAct : AppCompatActivity() {
    lateinit var binding: ActivityEditAdsBinding
    private val dialog = DialogSpinerHelper()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditAdsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()

    }

    private fun init(){

    }

    //OnClicks
    fun onClickSelectCity(view:View) {
        val listCity = CityHepler.getAllRegions(this)
        dialog.showSpinnerDialog(this,listCity)
    }

}