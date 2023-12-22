package com.bangkit.pregai.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import com.bangkit.pregai.ui.auth.AuthActivity
import pregai.databinding.ActivityLauncherBinding

@AndroidEntryPoint
class LauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLauncherBinding.inflate(layoutInflater)
        setContentView(binding.root)


        startActivity(Intent(this, AuthActivity::class.java))
        finish()
    }
}