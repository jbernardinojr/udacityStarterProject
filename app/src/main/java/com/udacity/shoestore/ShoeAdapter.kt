package com.udacity.shoestore

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.udacity.shoestore.databinding.ShoeItemListBinding
import com.udacity.shoestore.models.Shoe

class ShoeAdapter(
    private val dataSet: List<Shoe>,
    private val clickListener: (shoe: Shoe) -> Unit
) :
    RecyclerView.Adapter<ShoeAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ShoeItemListBinding, private val clickListener: (shoe: Shoe) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            initClickListeners()
        }

        private fun initClickListeners() {
            itemView.setOnClickListener { clickListener(dataSet[adapterPosition]) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ShoeItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false), clickListener)


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val shoe = dataSet[position]
        holder.binding.tvListShoeName.text = shoe.name
        holder.binding.tvCompanyManufactory.text = shoe.company
        holder.binding.tvListDescription.text = shoe.description

    }

    override fun getItemCount() = dataSet.size


}