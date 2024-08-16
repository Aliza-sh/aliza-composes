package com.aliza.alizacomposes.movies.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.aliza.alizacomposes.R
import com.aliza.alizacomposes.movies.model.Movie
import com.aliza.alizacomposes.movies.ui.theme.AppGold
import com.aliza.alizacomposes.movies.ui.theme.AppGray
import com.aliza.alizacomposes.movies.ui.theme.AppWhite

@Composable
fun PopularMoviesList(movies: List<Movie>) {
    LazyRow(
        contentPadding = PaddingValues(25.dp, 0.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        items(movies) { movie ->
            PopularMoviesItem(movie)
        }
    }
}

@Composable
fun PopularMoviesItem(movie: Movie) {
    Card(
        modifier = Modifier
            .width(150.dp)
            .height(230.dp)
            .clip(RoundedCornerShape(15.dp)),
        elevation = CardDefaults.elevatedCardElevation(8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(15.dp))
        ) {
            Image(
                painter = painterResource(id = movie.image),
                contentDescription = "",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(bottomEnd = 8.dp))
                    .background(AppGray)
                    .padding(4.dp)
                    .align(Alignment.TopStart),
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_star),
                    contentDescription = "Rank",
                    tint = AppGold,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(1.dp))
                Text(text = movie.rank.toString(), color = AppWhite)
            }

        }
    }
}