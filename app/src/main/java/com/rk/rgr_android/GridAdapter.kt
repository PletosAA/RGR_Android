package com.rk.rgr_android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GridAdapter(private val items: List<GridItem>, val listener: OnItemClickListener) : RecyclerView.Adapter<GridAdapter.Holder>() {
    interface OnItemClickListener {
        fun onItemClick(item: GridItem)
    }

    inner class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val text: TextView = view.findViewById(R.id.gridText)
        val layout: View = view
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_grid, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = items[position]
        holder.text.text = item.value.toString()
        holder.layout.setBackgroundColor(item.color)
        holder.layout.setOnClickListener { listener.onItemClick(item) }
    }

    override fun getItemCount(): Int = items.size
}