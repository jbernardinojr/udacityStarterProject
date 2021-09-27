package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment: Fragment() {

    private lateinit var binding: ShoeDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ShoeDetailFragmentBinding.inflate(inflater)
        .apply {
            lifecycleOwner = viewLifecycleOwner
            binding = this
            binding.btnSave.setOnClickListener { view: View ->
                val newShoe = onSaveShoe(ACTION_SAVE)
                val action = ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment(newShoe)
                view.findNavController().navigate(action)
            }
            binding.btnCancel.setOnClickListener { view: View ->
                val emptyShoe = onSaveShoe(ACTION_CANCEL)
                view.findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment(emptyShoe))
            }
        }
        .root

    private fun onSaveShoe(typeAction: Int): Shoe {
        var newShoe = Shoe("", 0.0, "", "", emptyList())

        if (typeAction == ACTION_SAVE) {
            newShoe.name = binding.edtShoeName.text.toString()
            newShoe.description = binding.edtDescription.text.toString()
            newShoe.company = binding.edtManufactoryName.text.toString()
            newShoe.size = binding.edtShoeSize.toString().toDouble()
        }

        return newShoe
    }

    companion object {
        private val ACTION_SAVE = 0
        private val ACTION_CANCEL = 1
    }

}