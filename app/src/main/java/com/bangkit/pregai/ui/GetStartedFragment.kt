package com.bangkit.pregai.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import pregai.R
import com.bangkit.pregai.utils.binding.viewBinding
import pregai.databinding.FragmentGetStartedBinding

class GetStartedFragment : Fragment(R.layout.fragment_get_started) {

    private val binding by viewBinding(FragmentGetStartedBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.getStartedBtn.setOnClickListener {
            findNavController().navigate(R.id.action_get_started_trampoline_fragment_to_auth_chooser_fragment)
        }
    }
}