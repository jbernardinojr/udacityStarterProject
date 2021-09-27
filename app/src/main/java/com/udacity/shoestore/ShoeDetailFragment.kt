package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.ShoeListViewModel

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: ShoeDetailFragmentBinding
    private val args: ShoeDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ShoeDetailFragmentBinding.inflate(inflater)
        .apply {

            lifecycleOwner = viewLifecycleOwner
            binding = this

            args.shoe?.let { showShoe(it) }
            
            binding.btnSave.setOnClickListener { view: View ->
                val newShoe = onSaveShoe(ACTION_SAVE)
                val action =
                    ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment(newShoe)
                view.findNavController().navigate(action)
            }

            binding.btnCancel.setOnClickListener { view: View ->
                val emptyShoe = onSaveShoe(ACTION_CANCEL)
                view.findNavController().navigate(
                    ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment(
                        emptyShoe
                    )
                )
            }
        }
        .root

    private fun onSaveShoe(typeAction: Int): Shoe {
        var newShoe = Shoe("", 0.0, "", "", emptyList())

        if (typeAction == ACTION_SAVE) {
            newShoe.name = binding.edtShoeName.text.toString()
            newShoe.description = binding.edtDescription.text.toString()
            newShoe.company = binding.edtManufactoryName.text.toString()
            newShoe.size = binding.edtShoeSize.text.toString().toDouble()
        }

        return newShoe
    }

    private fun showShoe(shoe: Shoe) {
        if (!shoe.name.isNullOrBlank() && !shoe.name.isNullOrEmpty()) {
            binding.edtShoeName.setText(shoe.name)
            binding.edtDescription.setText(shoe.description)
            binding.edtManufactoryName.setText(shoe.company)
            binding.edtShoeSize.setText(shoe.size.toString())
        }
    }

    companion object {
        private val ACTION_SAVE = 0
        private val ACTION_CANCEL = 1
    }

}