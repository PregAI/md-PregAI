//package com.bangkit.pregai.ui.onboarding
//
//import android.content.Intent
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.view.animation.Animation
//import android.view.animation.AnimationUtils
//import androidx.core.view.isVisible
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.activityViewModels
//import androidx.lifecycle.lifecycleScope
//import androidx.viewpager2.widget.ViewPager2
//import pregai.R
//import pregai.databinding.FragmentOnboardingBinding
//import com.bangkit.pregai.ui.auth.AuthActivity
//import dagger.hilt.android.AndroidEntryPoint
//import com.bangkit.pregai.adapters.OnboardingAdapter
//import com.bangkit.pregai.utils.binding.viewBinding
//
//@AndroidEntryPoint
//class OnboardingFragment : Fragment() {
//
//    private val binding by viewBinding(FragmentOnboardingBinding::bind)
//    private val viewModel by activityViewModels<OnBoardingViewModel>()
//    private lateinit var onBoardingAdapter: OnboardingAdapter
//    private lateinit var animation: Animation
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        return inflater.inflate(R.layout.fragment_onboarding, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        onBoardingAdapter = OnboardingAdapter(viewModel.onboardingList)
//        animation = AnimationUtils.loadAnimation(requireContext(), R.anim.scale_from_center)
//        setupViewPager()
//        collectUiState()
//        collectUiEvents()
//        binding.skipButton.setOnClickListener {
//            viewModel.onSKipButtonPressed()
//        }
//        binding.nextButton.setOnClickListener {
//            viewModel.onNextButtonPressed()
//        }
//        binding.dotsIndicator.dotsClickable = false
//    }
//
//    private fun collectUiState() = viewLifecycleOwner.lifecycleScope.launchWhenStarted {
//        viewModel.uiState.collect {
//            binding.title.text = it.title
//            binding.title.startAnimation(animation)
//            binding.description.text = it.subtitle
//            binding.description.startAnimation(animation)
//            binding.skipButton.isVisible = it.isSkipButtonVisible
//        }
//    }
//
//    private fun collectUiEvents() = viewLifecycleOwner.lifecycleScope.launchWhenStarted {
//        viewModel.events.collect {
//            when (it) {
//                OnBoardingScreenEvents.NavigateToLoginScreen -> navigateToLoginScreen()
//                is OnBoardingScreenEvents.ShowNextPage -> showNextPage(it.pageNo)
//            }
//        }
//    }
//
//    private fun setupViewPager() {
//        binding.viewPager.apply {
//            isUserInputEnabled = false
//            adapter = onBoardingAdapter
//        }
//        binding.dotsIndicator.setViewPager2(binding.viewPager)
//    }
//
//    private fun showNextPage(pageNo: Int) {
//        binding.viewPager.setCurrentItem(pageNo, true)
//    }
//
//    private fun navigateToLoginScreen() {
//        Intent(requireContext(), AuthActivity::class.java).also {
//            startActivity(it)
//            requireActivity().finish()
//        }
//    }
//}
