package com.udacity.shoestore.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.WelcomeScreenBinding

class WelcomeFragment: Fragment() {

    private lateinit var binding: WelcomeScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.welcome_screen, container, false)

        return binding.apply {
            lifecycleOwner = this@WelcomeFragment
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