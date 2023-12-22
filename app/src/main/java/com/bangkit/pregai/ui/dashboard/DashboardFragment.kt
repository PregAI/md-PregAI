package com.bangkit.pregai.ui.dashboard

import android.os.Bundle
import android.os.Vibrator
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.pregai.ui.LightningYogaPosesFactory
import com.bangkit.pregai.ui.history.HistoryFragment
import pregai.R
import pregai.databinding.FragmentDashboardBinding
import pregai.databinding.OtherPoseLayoutBinding
import pregai.databinding.YogaCategoryItemBinding
import pregai.databinding.YogaCategoryLayoutBinding
import com.bangkit.pregai.utils.binding.viewBinding
import com.bangkit.pregai.utils.extensions.navigate


class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private val viewModel by activityViewModels<DashboardViewModel>()
    private lateinit var navController: NavController
    private lateinit var vibrator: Vibrator


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initYogaCategoryView(view)
        val binding = FragmentDashboardBinding.bind(view)
//        replaceFragment(DashboardFragment())
//
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



        binding.myRoutineLayout.routineRoot.setOnClickListener {
            navigate(R.id.action_dashboard_to_my_routines)
        }

        binding.historyLayout.routineRoot.setOnClickListener {
            navigate(R.id.action_dashboard_to_history)
        }
    }


//    private fun replaceFragment(fragment : Fragment) {
//        val fragmentManager = parentFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.frame_layout,fragment)
//        fragmentTransaction.commit()
//    }

    // Entry point for included OtherPoseLayoutBinding
    private fun initOtherPoseView(view: View, bundle: Bundle) {
        navigate(R.id.pose_detection_action, bundle)
        val binding = OtherPoseLayoutBinding.bind(view)

    }


    // Entry point for included YogaCategoryLayoutBinding
    private fun initYogaCategoryView(view: View) {
        val categoryBinding = YogaCategoryLayoutBinding.bind(view)
        categoryBinding.listView.adapter = YogaCategoryAdapter(::navigateToPoseDetection)
        LightningYogaPosesFactory.singleton(requireContext())
    }

    private fun navigateToPoseDetection(bundle: Bundle) {
        navigate(R.id.pose_detection_action, bundle)
    }

    internal class YogaCategoryAdapter(
        private val listener: (Bundle) -> Unit
    ) : RecyclerView.Adapter<YogaCategoryAdapter.YogaCategoryViewHolder>() {

        private val categories = Category.create()

        internal data class Category(
            val title: String,
            @ColorRes val colorId: Int,
            @DrawableRes val drawable: Int
        ) {
            companion object {
                fun create() = listOf(
                    Category("Focus Trimester 1 ", R.color.light_blue, R.drawable.yoga_basic),
                    Category("Relax Trimester 2 ", R.color.light_peach, R.drawable.yoga_intermediate),
                    Category("Mindfulness Trimester 3 ", R.color.light_leaf, R.drawable.yoga_professional)
                )
            }
        }

        inner class YogaCategoryViewHolder(
            private val binding: YogaCategoryItemBinding
        ) : RecyclerView.ViewHolder(binding.root) {

            init {
                binding.root.setOnClickListener {
                    listener.invoke(
                        bundleOf(
                            "level" to adapterPosition,
                            "category" to categories[adapterPosition].title
                        )
                    )
                }
            }

            fun bind(category: Category) {
                binding.apply {
                    title.text = category.title
                    root.setCardBackgroundColor(
                        ContextCompat.getColor(
                            root.context,
                            category.colorId
                        )
                    )
                    thumbnail.setImageResource(category.drawable)
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YogaCategoryViewHolder {
            val binding = parent.viewBinding(YogaCategoryItemBinding::inflate)
            return YogaCategoryViewHolder(binding)
        }

        override fun getItemCount(): Int = categories.size

        override fun onBindViewHolder(holder: YogaCategoryViewHolder, position: Int) {
            holder.bind(categories[position])
        }
    }
}