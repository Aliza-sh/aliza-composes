package com.aliza.alizacomposes.instagram.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aliza.alizacomposes.R
import com.aliza.alizacomposes.instagram.data.MockData.users
import com.aliza.alizacomposes.instagram.model.Post

@Composable
fun PostWidget(
    post: Post
) {

    var liked by remember { mutableStateOf(false) }
    var numLiked by remember { mutableIntStateOf(post.likeCount) }
    var savaed by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape),
                    painter = painterResource(id = post.user.profilePic),
                    contentDescription = "Profile Pic",
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = post.user.username,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Text(
                        text = post.location,
                        fontSize = 14.sp
                    )
                }
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(R.drawable.ic_more),
                    contentDescription = "More Options"
                )
            }
        }
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = post.postPic),
            contentDescription = "Post Picture",
            contentScale = ContentScale.FillWidth
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {
                    liked = !liked
                    if (liked)
                        numLiked++
                    else
                        numLiked--
                }) {
                    Icon(
                        imageVector = if (liked) Icons.Rounded.Favorite else Icons.Rounded.FavoriteBorder,
                        contentDescription = "Like Icon",
                        tint = if (liked) Color.Red else MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.size(25.dp)
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(R.drawable.ic_comment),
                        contentDescription = "Like Icon",
                        tint = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.size(30.dp)
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(R.drawable.ic_send),
                        contentDescription = "Like Icon",
                        tint = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.size(25.dp)
                    )
                }
            }
            IconButton(onClick = { savaed = !savaed }) {
                Icon(
                    painter = if (savaed) painterResource(R.drawable.ic_save) else painterResource(R.drawable.ic_save_border),
                    contentDescription = "Like Icon",
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(28.dp)
                )
            }
        }
        Column(
            modifier = Modifier.padding(horizontal = 10.dp)
        ) {
            Text(
                text = "$numLiked likes"
            )
            Text(
                text = buildAnnotatedString {
                    append(
                        AnnotatedString(
                            text = "${post.user.username}  ",
                            spanStyle = SpanStyle(fontWeight = FontWeight.Bold)
                        )
                    )
                    append(post.caption)
                }
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "View all ${post.commentCount} comments",
                color = Color.DarkGray,
                fontSize = 13.sp
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
    }
}


@Preview(showBackground = true)
@Composable
fun PostWidgetPrev() {
    PostWidget(
        post = Post(
            user = users[6],
            location = "Accra, Ghana",
            postPic = R.drawable.jon_snow_post,
            likeCount = 168,
            caption = "Hey Guy's, checkout my new post",
            commentCount = 15
        )
    )
}