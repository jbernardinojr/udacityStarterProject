package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.WelcomeScreenBinding
import com.udacity.shoestore.viewmodel.WelcomeViewModel

class WelcomeFragment: Fragment() {

    private lateinit var binding: WelcomeScreenBinding
    private lateinit var viewModel: WelcomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel = ViewModelProvider(this).get(WelcomeViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.welcome_screen, container, false)

        return binding.apply {
            lifecycleOwner = this@WelcomeFragment
            welcomeViewModel = viewModel
            btnWelcomeGo.setOnClickListener { v: View ->
                setupNavigationAction(v)
            }
        }.root
    }


    private fun setupNavigationAction(v: View) {
        val action = WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment()
        v.findNavController()?.navigate(action)
    }
}