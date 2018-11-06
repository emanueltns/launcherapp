package com.devforfun.launchapp.ui;

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.devforfun.launchapp.R
import com.devforfun.launchapp.api.model.Launch
import com.devforfun.launchapp.utils.inflate
import com.devforfun.launchapp.utils.loadUrl
import kotlinx.android.synthetic.main.launcher_item.view.*

class LauncherAdapter(private val items : List<Launch>, val clickListener: (Launch) -> Unit) : RecyclerView.Adapter<LauncherViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LauncherViewHolder {
        return LauncherViewHolder(parent.inflate(R.layout.launcher_item));
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: LauncherViewHolder, position: Int) {
        holder.bind(items.get(position), clickListener)
    }
}

class LauncherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val image: ImageView = itemView.card_view.image
    val title : TextView = itemView.card_view.title

    fun bind(item: Launch, clickListener: (Launch) -> Unit) {
        image.loadUrl("https://s3.amazonaws.com/pix.iemoji.com/images/emoji/apple/ios-11/256/rocket.png")
        title.text = """${item.name} | ${item.status} | ${item.windowsStart}"""
        itemView.setOnClickListener { clickListener(item) }
    }
}