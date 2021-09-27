package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentInstructionsBinding
import com.udacity.shoestore.viewmodel.InstructionsViewModel

class InstructionsFragment : Fragment() {

    private lateinit var binding: FragmentInstructionsBinding
    private lateinit var viewModel: InstructionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel = ViewModelProvider(this).get(InstructionsViewModel::class.java)

        binding =  DataBindingUtil.inflate(inflater, R.layout.fragment_instructions, container, false)
        return  binding.apply {
            lifecycleOwner = this@InstructionsFragment
            instructionsViewModel = viewModel
            btnShowShoeList.setOnClickListener { view ->
                setupNavigationAction(view)
            }
        }.root
    }

    private fun setupNavigationAction(v: View) {
        val action = InstructionsFragmentDirections.actionInstructionsFragmentToShoeListFragment()
        v.findNavController()?.navigate(action)
    }
}