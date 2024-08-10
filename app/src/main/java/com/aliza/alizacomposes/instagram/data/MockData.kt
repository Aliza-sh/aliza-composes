package com.aliza.alizacomposes.instagram.data

import com.aliza.alizacomposes.R
import com.aliza.alizacomposes.instagram.model.Story

object MockData {

    val stories = ArrayList<Story>()

    init {
        stories.add(
            Story(
                1,
                "Arya",
                R.drawable.arya_stark,
                true
            )
        )
        stories.add(
            Story(
                2,
                "Bran",
                R.drawable.bran_stark,
                false
            )
        )
        stories.add(
            Story(
                3,
                "Daenerys",
                R.drawable.daenerys_targaryen,
                false
            )
        )
        stories.add(
            Story(
                4,
                "Jon",
                R.drawable.jon_snow,
                false
            )
        )
        stories.add(
            Story(
                5,
                "Jorah",
                R.drawable.jorah_mormont,
                false
            )
        )
        stories.add(
            Story(
                6,
                "Rob",
                R.drawable.rob_stark,
                false
            )
        )
        stories.add(
            Story(
                6,
                "Sansa",
                R.drawable.sansa_stark,
                false
            )
        )
        stories.add(
            Story(
                6,
                "Tyrian",
                R.drawable.tyrian_lannister,
                false
            )
        )
    }

}