package com.udacity.shoestore.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        return binding.apply {
            lifecycleOwner = this@LoginFragment

            btnCreateNewLogin.setOnClickListener { v: View ->
                setupNavigationAction(v)
            }

            btnLoginExistAccount.setOnClickListener { v: View ->
                setupNavigationAction(v)
            }
        }.root
    }

    private fun setupNavigationAction(v: View) {
        val action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()
        v.findNavController()?.navigate(action)
    }
}