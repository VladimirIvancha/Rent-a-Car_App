package com.example.rent_a_car_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rent_a_car_app.databinding.SizeListItemBinding

class CarsSizeListAdapter : RecyclerView.Adapter<CarsSizeListAdapter.ViewHolder>() {

    private var items = mutableListOf<Int>()
    init {
        var year = 2017
        while (year <= 2022) {
            year += 1
            items.add(year)
        }
    }

    private var itemClick: (Int) -> Unit = {}
    fun itemClick(listener: (Int) -> Unit) {
        itemClick = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.size_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.sizeItemText.text = items[position].toString()
        holder.itemView.setOnClickListener {
            itemClick(items[position])
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding = SizeListItemBinding.bind(view)
    }
}