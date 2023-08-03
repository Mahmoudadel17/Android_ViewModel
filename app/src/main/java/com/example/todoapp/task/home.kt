package com.example.todoapp.task

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.todoapp.R


@Composable
fun HomeRegister(
    firstName: String,
    lastName: String,
    email: String,
    age: String
) {
    CardPerson(firstName,lastName,email,age)

}

@Preview(showSystemUi = true)
@Composable
fun CardPerson(firstName: String = "", lastName: String = "", email: String = "", age: String ="0") {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background),
        shape = RoundedCornerShape(15.dp),
    ){
       Column(  horizontalAlignment = Alignment.CenterHorizontally,
           verticalArrangement = Arrangement.Center,
       ) {
           Image(
               painter = painterResource(id = R.drawable.user),
               contentDescription ="",
               contentScale = ContentScale.Crop,
               modifier = Modifier.padding(8.dp).size(40.dp),
           )
           Row {
               Text(text = firstName)
               Spacer(modifier = Modifier.width(10.dp))
               Text(text = lastName)
           }
           Text(text = email)
           Text(text = age)
       }

    }
}