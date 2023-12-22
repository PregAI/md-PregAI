package com.bangkit.pregai.ui

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import pregai.R
import com.bangkit.pregai.utils.extensions.setupToolbarNavigateUp

abstract class NavFragment(@LayoutRes open val layoutId: Int) : Fragment(layoutId) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbarNavigateUp(view.findViewById(R.id.toolbar) ?: return)
    }
}