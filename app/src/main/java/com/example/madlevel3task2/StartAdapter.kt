package com.example.madlevel3task2

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*

class StartAdapter(private var listOfLocation: ArrayList<Location>) : RecyclerView.Adapter<StartAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun databinding(location: Location) {
            itemView.itemTitle.text = location.title
            itemView.itemLocation.text = location.url

            val builder = CustomTabsIntent.Builder()
            val customTabsIntent = builder.build()
           itemView.setOnClickListener {
               customTabsIntent.launchUrl(itemView.context, Uri.parse(itemView.itemLocation.text.toString()))
             }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        )
    }
    override fun getItemCount(): Int {
        return listOfLocation.count()
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databinding(listOfLocation[position])
    }
}