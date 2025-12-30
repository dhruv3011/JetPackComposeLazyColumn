package com.dhruv.jetpackcomposelazycolumn.ui.list

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.dhruv.jetpackcomposelazycolumn.R
import com.dhruv.jetpackcomposelazycolumn.model.Pokemon

@Composable
fun ListViewCell(pokemon: Pokemon,
                 onPokemonClick: (pokemon: Pokemon) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        onClick = { onPokemonClick(pokemon) },
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(8.dp)
            ) {
                AsyncImage(
                    model = pokemon.imgUrl,
                    contentDescription = "Pokemon Image",
                    placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
                    error = painterResource(id = R.drawable.ic_launcher_foreground),
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color.Gray.copy(alpha = 0.3f))
                        .padding(8.dp),
                    contentScale = ContentScale.Fit,
                    onError = {
                        Log.e("Coil", "Image load failed", it.result.throwable)
                    }
                )
                Text(
                    text = pokemon.name.uppercase(),
                    modifier = Modifier.padding(4.dp)
                )
                Spacer(modifier = Modifier.fillMaxWidth())
            }
        }
    }
}