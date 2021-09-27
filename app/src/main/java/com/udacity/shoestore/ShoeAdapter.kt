package com.udacity.shoestore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.udacity.shoestore.databinding.ShoeItemListBinding
import com.udacity.shoestore.models.Shoe

class ShoeAdapter(private val dataSet: List<Shoe>) :
    RecyclerView.Adapter<ShoeAdapter.ViewHolder>(){

    inner class ViewHolder(val binding: ShoeItemListBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = ShoeItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val shoe = dataSet[position]

        holder.binding.tvListShoeName.text = shoe.name
        holder.binding.tvCompanyManufactory.text = shoe.company
        holder.binding.tvListDescription.text = shoe.description

    }

    override fun getItemCount() = dataSet.size

}