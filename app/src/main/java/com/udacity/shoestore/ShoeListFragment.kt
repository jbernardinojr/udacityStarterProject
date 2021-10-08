package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.ShoeListViewModel
import com.udacity.shoestore.viewmodel.ShoesListViewModelFactory

class ShoeListFragment : Fragment() {

    private var listShoe: MutableList<Shoe> = mutableListOf(
        Shoe("Shoe 1", 30.0, "Nike", "Beautiful nike Shoe", emptyList()),
        Shoe("Shoe 2", 31.0, "Adidas", "Beautiful Adidas Shoe", emptyList()),
        Shoe("Shoe 3", 32.0, "Rebook", "Beautiful Rebook Shoe", emptyList())
    )

    private val viewModel: ShoeListViewModel by viewModels {
        ShoesListViewModelFactory(listShoe)
    }

    private val args: ShoeListFragmentArgs by navArgs()

    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentShoeListBinding.inflate(inflater)
        .apply {

            lifecycleOwner = viewLifecycleOwner
            binding = this

            args.shoe?.let { newShoe ->
                viewModel.updateShoeList(newShoe)
            }

            binding.fbMoreDetails.setOnClickListener {
                setupNavigationAction(Shoe(name= "", description = "", size = 0.0, company = "", images = emptyList()))
            }

            setupAdapter(emptyList())
            setupObserveEvents()
        }.root

    private fun setupObserveEvents() {
        viewModel.shoeList.observe(viewLifecycleOwner, { shoes ->
            setupAdapter(shoes)
        })
    }

    private fun setupAdapter(shoes: List<Shoe>) {
        val adapter = ShoeAdapter(shoes) { shoe ->
            setupNavigationAction(shoe)
        }
        binding.rvShoeList.adapter = adapter
        binding.rvShoeList.layoutManager = LinearLayoutManager(activity)
    }

    private fun setupNavigationAction(shoe: Shoe) {
        val action = ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment(shoe)
        view?.findNavController()?.navigate(action)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ShoeListFragment()
    }
}