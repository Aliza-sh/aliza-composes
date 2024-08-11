package com.aliza.alizacomposes.instagram.data

import com.aliza.alizacomposes.R
import com.aliza.alizacomposes.instagram.model.Post
import com.aliza.alizacomposes.instagram.model.Story
import com.aliza.alizacomposes.instagram.model.User

object MockData {

    val stories = ArrayList<Story>()
    var users = ArrayList<User>()
    var posts = ArrayList<Post>()

    init {
        stories.add(
            Story(
                1,
                "Arya",
                R.drawable.arya_stark,
                true,
                true
            )
        )
        stories.add(
            Story(
                2,
                "Bran",
                R.drawable.bran_stark,
                true,
                false
            )
        )
        stories.add(
            Story(
                3,
                "Daenerys",
                R.drawable.daenerys_targaryen,
                true,
                false
            )
        )
        stories.add(
            Story(
                4,
                "Jon",
                R.drawable.jon_snow,
                true,
                false
            )
        )
        stories.add(
            Story(
                5,
                "Jorah",
                R.drawable.jorah_mormont,
                true,
                false
            )
        )
        stories.add(
            Story(
                6,
                "Rob",
                R.drawable.rob_stark,
                false,
                false
            )
        )
        stories.add(
            Story(
                6,
                "Sansa",
                R.drawable.sansa_stark,
                false,
                false
            )
        )
        stories.add(
            Story(
                6,
                "Tyrian",
                R.drawable.tyrian_lannister,
                false,
                false
            )
        )

        users = arrayListOf(
            User(
                profilePic = R.drawable.jon_snow,
                username = "jon_snow",
                fullName = "Jon Snow"
            ),
            User(
                profilePic = R.drawable.arya_stark,
                username = "arya_stark",
                fullName = "Arya Stark"
            ),
            User(
                profilePic = R.drawable.bran_stark,
                username = "bran_stark",
                fullName = "Bran Stark"
            ),
            User(
                profilePic = R.drawable.daenerys_targaryen,
                username = "queen_daenerys",
                fullName = "Queen Daenerys"
            ),
            User(
                profilePic = R.drawable.jorah_mormont,
                username = "jorah_m",
                fullName = "Jorah Mormont"
            ),
            User(
                profilePic = R.drawable.rob_stark,
                username = "robb_stark",
                fullName = "Robb Stark"
            ),
            User(
                profilePic = R.drawable.sansa_stark,
                username = "sansa_stark",
                fullName = "Sansa Stark"
            ),
            User(
                profilePic = R.drawable.tyrian_lannister,
                username = "tyrian_lan",
                fullName = "Tyrian Lan"
            )
        )

        posts = arrayListOf(
            Post(
                user = users[0],
                location = "Accra, Ghana",
                postPic = R.drawable.jon_snow_post,
                likeCount = 168,
                caption = "Hey Guy's, checkout my new post",
                commentCount = 15
            ),
            Post(
                user = users[1],
                location = "Accra, Ghana",
                postPic = R.drawable.arya_stark_post,
                likeCount = 168,
                caption = "Hey Guy's, checkout my new post",
                commentCount = 15
            ),
            Post(
                user = users[2],
                location = "Accra, Ghana",
                postPic = R.drawable.bran_stark_post,
                likeCount = 168,
                caption = "Hey Guy's, checkout my new post",
                commentCount = 15
            ),
            Post(
                user = users[3],
                location = "Accra, Ghana",
                postPic = R.drawable.daenerys_targaryen_post,
                likeCount = 168,
                caption = "Hey Guy's, checkout my new post",
                commentCount = 15
            ),
            Post(
                user = users[4],
                location = "Accra, Ghana",
                postPic = R.drawable.jorah_mormont_post,
                likeCount = 168,
                caption = "Hey Guy's, checkout my new post",
                commentCount = 15
            ),
            Post(
                user = users[5],
                location = "Accra, Ghana",
                postPic = R.drawable.robb_stark_post,
                likeCount = 168,
                caption = "Hey Guy's, checkout my new post",
                commentCount = 15
            ),
            Post(
                user = users[6],
                location = "Accra, Ghana",
                postPic = R.drawable.sansa_stark_post,
                likeCount = 168,
                caption = "Hey Guy's, checkout my new post",
                commentCount = 15
            ),
            Post(
                user = users[7],
                location = "Accra, Ghana",
                postPic = R.drawable.tyrian_lannister_post,
                likeCount = 168,
                caption = "Hey Guy's, checkout my new post",
                commentCount = 15
            )
        )
    }
}