package com.devforfun.launchapp.ui

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.Toast
import com.devforfun.launchapp.R
import com.devforfun.launchapp.api.model.Launch
import com.devforfun.launchapp.databinding.ActivityMainBinding
import com.devforfun.launchapp.viewmodel.LauncherViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    lateinit var adapter: LauncherAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: LauncherViewModel
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding  = DataBindingUtil.setContentView(this, R.layout.activity_main)

//        //init view model
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(LauncherViewModel::class.java)
        viewModel.init()
        subscribeLiveObjects()
        binding.launchItems.layoutManager = GridLayoutManager(this,1)
    }

    private fun subscribeLiveObjects() {

        viewModel.successHandler.observe(this, android.arch.lifecycle.Observer { it ->
            it?.let {
                binding.progressCircular.visibility = View.GONE
                //update adapter
                adapter = LauncherAdapter(it.items) { item: Launch -> itemClicked(item) }
                binding.launchItems.adapter = adapter
            }
        })
        viewModel.errorHandler.observe(this, android.arch.lifecycle.Observer { it ->
            it?.let {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
                binding.progressCircular.visibility = View.GONE
            }
        })
    }

    private fun itemClicked(launch: Launch) {
        Toast.makeText(this, "Clicked: ${launch.name}", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(getString(R.string.EXTRA_LAUNCH), launch)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.clear()
    }
}
