package com.bangkit.pregai.ui.profileScreen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import pregai.R
import pregai.databinding.FragmentProfileBinding
import com.bangkit.pregai.utils.binding.viewBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private val binding by viewBinding(FragmentProfileBinding::bind)
    private val viewModel by viewModels<ProfileViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.aboutButton.setOnClickListener {
            viewModel.onAboutPressed()
        }
        binding.logoutButton.setOnClickListener {
            viewModel.onLogoutPressed()
        }
    }



    private fun navigateToAboutScreen() {
        findNavController().navigate(R.id.action_dashboard_to_history)
    }

}
