package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import com.udacity.shoestore.viewmodel.ShoeListViewModel

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: ShoeDetailFragmentBinding

    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ShoeDetailFragmentBinding.inflate(inflater)
        .apply {

            lifecycleOwner = viewLifecycleOwner
            binding = this
            vm = viewModel

            setupObservers()
        }
        .root

    private fun setupObservers() {
        viewModel.saveAction.observe(viewLifecycleOwner, { isSaved ->
            if (isSaved) {
                val action =
                    ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
                view?.findNavController()?.navigate(action)
                viewModel.onSavedComplete()
            }
        })

        viewModel.cancelAction.observe(viewLifecycleOwner, { isCancel ->
            if (isCancel) {
                val action =
                    ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
                view?.findNavController()?.navigate(action)
                viewModel.onCancelComplete()
            }
        })
    }
}