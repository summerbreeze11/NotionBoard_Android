package com.summerbreeze11.notionboard.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.summerbreeze11.notionboard.databinding.ActivityEditAdsBinding
import com.summerbreeze11.notionboard.utils.CityHepler
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

class EditAdsAct : AppCompatActivity() {
    private lateinit var binding: ActivityEditAdsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditAdsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, CityHepler.getAllRegions(this))
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spCountry.adapter = adapter

    }
}