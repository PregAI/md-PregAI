package com.bangkit.pregai.ui.auth.login

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import pregai.R
import pregai.databinding.FragmentAuthChooserBinding
import com.bangkit.pregai.ui.NavFragment

class AuthChooserFragment : NavFragment(R.layout.fragment_auth_chooser) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentAuthChooserBinding.bind(view)

        binding.guestLogin.setOnClickListener {
            findNavController().navigate(R.id.action_auth_chooser_fragment_to_dashboard)
        }

        binding.emailSignInBtn.setOnClickListener {
            findNavController().navigate(R.id.action_auth_chooser_fragment_to_loginFragment)
        }

    }
}
