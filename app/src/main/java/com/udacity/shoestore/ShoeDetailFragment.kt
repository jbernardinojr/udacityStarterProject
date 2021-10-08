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
import com.udacity.shoestore.viewmodel.ShoeDetailViewModel

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: ShoeDetailFragmentBinding
    private val args: ShoeDetailFragmentArgs by navArgs()

    private val viewModel: ShoeDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ShoeDetailFragmentBinding.inflate(inflater)
        .apply {

            lifecycleOwner = viewLifecycleOwner
            binding = this
            vm = viewModel

            args.shoe?.let { viewModel.showShoe(it) }

            setupObservers()
        }
        .root

    private fun setupObservers() {
        viewModel.saveShoe.observe(viewLifecycleOwner, { shoe ->
            val action = ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment(shoe)
            view?.findNavController()?.navigate(action)
        })

        viewModel.cancelAction.observe(viewLifecycleOwner, { isCancel ->
            if (isCancel) {
                val action =
                    ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment(null)
                view?.findNavController()?.navigate(action)
            }
        })
    }
}