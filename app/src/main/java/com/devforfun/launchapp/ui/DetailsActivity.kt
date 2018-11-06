package com.devforfun.launchapp.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.devforfun.launchapp.R
import com.devforfun.launchapp.databinding.DetailsActivityBinding

class DetailsActivity : AppCompatActivity() {

    lateinit var binding : DetailsActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.details_activity)
        binding.data = intent.extras?.getParcelable(getString(R.string.EXTRA_LAUNCH))
    }
}
