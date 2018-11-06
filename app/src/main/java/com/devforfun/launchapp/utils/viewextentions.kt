package com.devforfun.launchapp.utils

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.devforfun.launchapp.R
import com.devforfun.launchapp.viewmodel.LauncherViewModel
import com.squareup.picasso.Picasso

fun ViewGroup.inflate(layoutRes : Int) : View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}

fun ImageView.loadUrl(url : String?) {
    Picasso.get().load(url)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(this);
}

fun RecyclerView.gridLayout(spanCount : Int)  {
    layoutManager = GridLayoutManager(context,spanCount)
}
