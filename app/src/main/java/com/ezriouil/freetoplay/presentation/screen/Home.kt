package com.ezriouil.freetoplay.presentation.screen

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ezriouil.freetoplay.R
import com.ezriouil.freetoplay.domain.model.Game
import com.ezriouil.freetoplay.presentation.component.home.GameCard
import com.ezriouil.freetoplay.presentation.component.home.Header
import com.ezriouil.freetoplay.utils.Resource

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Home(
    onClickDrawer: () -> Unit,
    onClickSearch: () -> Unit,
    games: Resource<List<Game>>,
    onGameClick: (Int?) -> Unit
) {
    when (games) {
        is Resource.Success -> {
            Column(modifier = Modifier.fillMaxSize()) {
                //Header
                Header(
                    title = "GAMES",
                    textColor = Color.White,
                    iconStart = painterResource(id = R.drawable.ic_menu),
                    iconStartColor = Color.White,
                    iconStartClick = onClickDrawer,
                    iconEnd = painterResource(id = R.drawable.ic_magnifying_glass_solid),
                    iconEndColor = Color.White,
                    iconEndClick = onClickSearch
                )
                //Cards
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(5.dp)
                ) {
                    items(games.data) { game ->
                        GameCard(
                            title = game.title,
                            description = game.shortDescription,
                            image = game.thumbnail!!,
                            platform = game.platform!!,
                            onClick = { onGameClick(game.id) }
                        )
                    }
                }
            }
        }
        is Resource.Error -> {
            Text(text = games.msg, style = MaterialTheme.typography.h3, color = Color.White)
            Log.d("TAG", "Home: ${games.msg}")
        }
        is Resource.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(color = Color.White)
            }
        }
    }
}