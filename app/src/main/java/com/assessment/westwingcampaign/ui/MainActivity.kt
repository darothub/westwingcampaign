package com.assessment.westwingcampaign.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import com.assessment.westwingcampaign.R
import com.assessment.westwingcampaign.databinding.ActivityMainBinding
import com.darotpeacedude.core.utils.hideSystemUI
import com.darotpeacedude.eivom.utils.viewBinding

class MainActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityMainBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = binding.root
        setContentView(view)
        hideSystemUI()
    }
}