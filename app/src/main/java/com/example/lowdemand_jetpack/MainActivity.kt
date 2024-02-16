package com.example.lowdemand_jetpack

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lowdemand_jetpack.ui.theme.LowDemand_JetpackTheme
import androidx.compose.foundation.Image
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LowDemand_JetpackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        TopBar()

                        FirstPost()

                        SecondPost()
                    }

                }
            }
        }
    }
}

@SuppressLint("PrivateResource")
@Composable
fun TopBar() {
    var menuExpanded by remember {
        mutableStateOf(false)
    }

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 8.dp, top = 16.dp, end = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween) {
        Text(
            text = "Low Demand",
            fontSize = 32.sp,
        )
        Column {
            IconButton(
                onClick = {menuExpanded = !menuExpanded}) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu",
                    modifier = Modifier.size(48.dp)
                )
            }
            //Dropdown menu under hamburger menu
            DropdownMenu(
                expanded = menuExpanded,
                onDismissRequest = { menuExpanded = false }) {
                DropdownMenuItem(text = { Text("Page 1") }, onClick = { /*TODO*/ })
                DropdownMenuItem(text = {Text("Page 2")}, onClick = { /*TODO*/ })
                DropdownMenuItem(text = { Text("Page 3") }, onClick = { /*TODO*/ })
            }
        }
    }
}


@Composable
fun FirstPost() {
    val image = painterResource(R.drawable.photo1)

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 16.dp, start = 8.dp, end = 8.dp, bottom = 16.dp)) {
        Image(
            painter = image,
            contentDescription = "First Image",
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(text = "My Bedroom")

        Text(text = "Published 27/1-24 10:04",
            fontSize = 8.sp)
    }
}

@Composable
fun SecondPost() {
    val image = painterResource(R.drawable.photo2)

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 16.dp, start = 8.dp, end = 8.dp, bottom = 16.dp)) {
        Image(
            painter = image,
            contentDescription = "First Image",
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(text = "My Garden")

        Text(text = "Published 27/1-24 10:04",
            fontSize = 8.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarReview() {
    TopBar()
}

@Preview
@Composable
fun FirstPostReview() {
    FirstPost()
}