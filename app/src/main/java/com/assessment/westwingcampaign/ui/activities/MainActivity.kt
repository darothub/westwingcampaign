package com.assessment.westwingcampaign.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.assessment.westwingcampaign.databinding.ActivityMainBinding
import com.darotpeacedude.core.utils.hideSystemUI
import com.darotpeacedude.eivom.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityMainBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = binding.root
        setContentView(view)
        hideSystemUI()
    }
}
