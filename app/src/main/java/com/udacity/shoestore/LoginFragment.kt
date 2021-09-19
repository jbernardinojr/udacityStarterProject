package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.viewmodel.LoginViewModel
import com.udacity.shoestore.viewmodel.WelcomeViewModel

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        return binding.apply {
            lifecycleOwner = this@LoginFragment
            loginViewModel = viewModel

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