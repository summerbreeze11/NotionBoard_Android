package com.summerbreeze11.notionboard.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.summerbreeze11.notionboard.databinding.ActivityEditAdsBinding

class EditAdsAct : AppCompatActivity() {
    private lateinit var binding:ActivityEditAdsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditAdsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}