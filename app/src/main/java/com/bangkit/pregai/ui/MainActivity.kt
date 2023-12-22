package com.bangkit.pregai.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.AndroidEntryPoint
import pregai.R
import com.bangkit.pregai.data.auth.UserDataSource
import pregai.databinding.ActivityMainBinding
import com.bangkit.pregai.utils.binding.viewBinding
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() , OnBackPressListener{

    private lateinit var navController: NavController
    private val binding by viewBinding(ActivityMainBinding::inflate)

    @Inject
    lateinit var authDataSource: UserDataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//        replaceFragment(DashboardFragment())

//       binding.bottomNav.setOnItemSelectedListener {
//
//           when(it.itemId) {
//               R.id.dashboardFragment -> replaceFragment(DashboardFragment())
//               R.id.statsFragment -> replaceFragment(HistoryFragment())
//               R.id.profileFragment -> replaceFragment(HistoryFragment())
//               else -> {
//               }
//           }
//
//                true
//       }

        navController = findNavController(R.id.nav_host_fragment_content_main)

        lifecycleScope.launchWhenCreated {
            FirebaseFirestore.getInstance()
                .collection("username")
                .document("pregai")
                .get().await()
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
                || super.onSupportNavigateUp()
    }

//    private fun replaceFragment(fragment : Fragment) {
//        val fragmentManager = supportFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.frame_layout,fragment)
//        fragmentTransaction.commit()
//    }

    override fun onNavigateBack() {
        navController.navigateUp()
    }
       }



