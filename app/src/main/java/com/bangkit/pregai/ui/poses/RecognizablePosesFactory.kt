package com.bangkit.pregai.ui.poses

import android.content.Context
import com.squareup.moshi.Moshi
import dagger.hilt.android.qualifiers.ApplicationContext
import pregai.R
import com.bangkit.pregai.model.PoseContent
import com.bangkit.pregai.model.PoseJournals
import com.bangkit.pregai.model.Poses
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RecognizablePosesFactory @Inject constructor(
    @ApplicationContext private val context: Context
) {

    private val beginner = arrayOf(
        Poses(
            "Warrior Pose",
            "",
            R.drawable.pose_advanced_warrior_1,
            R.color.light_blue,
            0
        ),
        Poses(
            "Tree Pose",
            "",
            R.drawable.pose_beginner_tree,
            R.color.light_blue,
            0
        ),
        Poses(
            "Cat Pose",
            "",
            R.drawable.pose_cat,
            R.color.light_blue,
            0
        ),
        Poses(
            "Cow Pose",
            "",
            R.drawable.pose_cow,
            R.color.light_blue,
            0
        ),
    )
    private val intermediate = arrayOf(
        Poses(
            "Cat Pose",
            "",
            R.drawable.pose_cat,
            R.color.light_blue,
            1
        ),
        Poses(
            "Cow Pose",
            "",
            R.drawable.pose_cow,
            R.color.light_blue,
            1
        ),
        Poses(
            "Standing Forward",
            "",
            R.drawable.pose_straight,
            R.color.light_blue,
            1
        )
    )
    private val advanced = arrayOf(
        Poses(
            "Cat Pose",
            "",
            R.drawable.pose_cat,
            R.color.light_blue,
            2
        ),
        Poses(
            "Cow Pose",
            "",
            R.drawable.pose_cow,
            R.color.light_blue,
            2
        ),
        Poses(
            "Warrior Pose",
            "",
            R.drawable.pose_advanced_warrior_1,
            R.color.light_blue,
            2
        ),
        Poses(
            "Warrior 2 Pose",
            "",
            R.drawable.pose_advanced_warrior_2,
            R.color.light_blue,
            2
        ),
    )

    fun getPoses(level: Int): List<Poses> {
        return when (level) {
            0 -> beginner
            1 -> intermediate
            2 -> advanced
            else -> throw IllegalStateException("Unknown Yoga category, but was $level")
        }.toList()
    }

    fun getPoseContent(level: Int, index: Int): PoseContent? {
        return getPoseList(level)?.get(index)
    }

    fun getPoseList(level: Int): List<PoseContent>? {
        val journals = PoseDescription.getFromCache(context)
        return when (level) {
            0 -> journals?.beginner
            1 -> journals?.intermediate
            2 -> journals?.advanced
            else -> throw IllegalStateException("Unknown Yoga category, but was $level")
        }
    }

    fun getAllPoses(): List<PoseContent?> {
        val journals = PoseDescription.getFromCache(context)
        val beginner = journals?.beginner ?: emptyList()
        val intermediate = journals?.intermediate ?: emptyList()
        val advanced = journals?.advanced ?: emptyList()
        return beginner + intermediate + advanced
    }

    private object PoseDescription {

        private var journals: PoseJournals? = null
        private const val FILENAME = "yoga_descriptions/yoga_journals.json"

        @JvmStatic
        fun getFromCache(context: Context): PoseJournals? {
            if (journals == null) {
                val string = context
                    .assets
                    .open(FILENAME)
                    .bufferedReader()
                    .use { it.readText() }

                val items = Moshi.Builder()
                    .build()
                    .adapter(PoseJournals::class.java)
                    .fromJson(string)

                journals = items
            }

            return journals
        }
    }
}