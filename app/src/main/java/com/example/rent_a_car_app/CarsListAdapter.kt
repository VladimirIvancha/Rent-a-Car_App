package com.example.rent_a_car_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rent_a_car_app.databinding.CarsListItemBinding
import com.example.rent_a_car_app.room.CarsData
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class CarsListAdapter : RecyclerView.Adapter<CarsListAdapter.ViewHolder>() {

    var items: List<CarsData> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    private var itemClick: (CarsData) -> Unit = {}
    fun itemClick(listener: (CarsData) -> Unit) {
        itemClick = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cars_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.cars = items[position]
        holder.itemView.setOnClickListener {
            itemClick(items[position])
        }
        val url = items[position].img
        Picasso.get()
            .load(url)
            .error(R.drawable.ic_baseline_hide_image_24)
            .fit()
            .into(holder.binding.image, object : Callback {
                override fun onSuccess() {

                }

                override fun onError(e: Exception?) {

                }

            })
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding = CarsListItemBinding.bind(view)

    }
}