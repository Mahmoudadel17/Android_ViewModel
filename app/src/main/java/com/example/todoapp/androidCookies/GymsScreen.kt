package com.example.todoapp.androidCookies

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todoapp.ui.theme.Purple40

@Preview( showBackground = true)
@Composable
fun GymsScreen() {
    LazyColumn{
        items(listOfGyms.size){
            GymItem(listOfGyms[it])
        }
    }

}

@Composable

fun GymItem(gym:Gym) {
    Card(
        modifier = Modifier.padding(8.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(16.dp),
        ) {
        Row(verticalAlignment = Alignment.CenterVertically,modifier = Modifier.padding(8.dp),) {
            GymIcon(Icons.Filled.Place,Modifier.weight(0.15f))
            GymDetails(gym,Modifier.weight(0.85f))
        }
    }
}

@Composable
fun GymDetails(gym: Gym,modifier: Modifier) {
    Column(modifier = modifier) {
        Text(
            text = gym.name,
            style = MaterialTheme.typography.h6,
            color = Purple40
        )
        CompositionLocalProvider (
            LocalContentAlpha provides ContentAlpha.medium){
            Text(
                text = gym.place,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.alpha(0.7f)
            )
        }
    }
}

@Composable
fun GymIcon(icon: ImageVector, modifier: Modifier) {
    Image(
        imageVector = icon,
        contentDescription = "Gym Icon",
        modifier = modifier,
        colorFilter = ColorFilter.tint(Color.DarkGray)
    )
}
