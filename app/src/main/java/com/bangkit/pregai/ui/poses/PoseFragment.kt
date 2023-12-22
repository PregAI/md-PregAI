package com.bangkit.pregai.ui.poses

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint
import pregai.R
import pregai.databinding.FragmentPoseBinding
import pregai.databinding.ItemPoseLayoutBinding
import com.bangkit.pregai.model.PoseUiModel
import com.bangkit.pregai.utils.binding.executeAfter
import com.bangkit.pregai.utils.binding.viewBinding
import com.bangkit.pregai.utils.extensions.launchWithViewLifecycle
import com.bangkit.pregai.utils.extensions.setupToolbarNavigateUp

@AndroidEntryPoint
class PoseFragment : Fragment(R.layout.fragment_pose) {

    private val viewModel by viewModels<PoseViewModel>()

    private val binding by viewBinding(FragmentPoseBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbarNavigateUp(binding.toolbar)

        val adapter = PoseAdapter()
        binding.listView.adapter = adapter

        launchWithViewLifecycle {
            viewModel.poses.collect(adapter::submitList)
        }

        launchWithViewLifecycle {
            viewModel.categories.collect {
                it.forEachIndexed { index, category ->
                    val chip: Chip = layoutInflater
                        .inflate(
                            R.layout.pose_chip_layout,
                            binding.chipGroup,
                            false
                        ) as Chip
                    chip.id = index + 1
                    chip.text = category

                    if (index == 0) {
                        chip.isChecked = true
                    }

                    binding.chipGroup.addView(chip)
                }

                binding.chipGroup.setOnCheckedStateChangeListener { _, checkedIds ->
                    viewModel.onSelectPoseCategory(checkedIds.first())
                }
            }
        }
    }

    internal class PoseAdapter : ListAdapter<PoseUiModel, PoseAdapter.PoseViewHolder>(DIFF_CALLBACK) {

        internal class PoseViewHolder(
            private val binding: ItemPoseLayoutBinding
        ) : RecyclerView.ViewHolder(binding.root) {

            fun bind(pose: PoseUiModel) {
                binding.executeAfter {
                    this.pose = pose
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PoseViewHolder {
            return PoseViewHolder(parent.viewBinding(ItemPoseLayoutBinding::inflate))
        }

        override fun onBindViewHolder(holder: PoseViewHolder, position: Int) {
            holder.bind(getItem(position))
        }

        companion object {
            private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<PoseUiModel>() {
                override fun areItemsTheSame(oldItem: PoseUiModel, newItem: PoseUiModel): Boolean {
                    return oldItem.thumbnail == newItem.thumbnail
                }

                override fun areContentsTheSame(
                    oldItem: PoseUiModel,
                    newItem: PoseUiModel
                ): Boolean {
                    return oldItem == newItem
                }

            }
        }
    }
}