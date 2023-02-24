package com.hyonglow.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hyonglow.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Preview
@Composable
fun LemonadeApp() {
    LemonadeWithButtonAndImage(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun LemonadeWithButtonAndImage(modifier: Modifier = Modifier) {

    var num by remember { mutableStateOf(0) }
    var imageResource by remember { mutableStateOf(R.drawable.lemon_tree) }
    var text by remember { mutableStateOf(R.string.lemon_select) }

    when (num) {
        0 -> {
            imageResource = (R.drawable.lemon_tree)
            text = R.string.lemon_select
        }
        1 -> {
            imageResource = (R.drawable.lemon_squeeze)
            text = R.string.lemon_squeeze
        }
        2 -> {
            imageResource = (R.drawable.lemon_drink)
            text = R.string.lemon_drink
        }
        3 -> {
            imageResource = (R.drawable.lemon_restart)
            text = R.string.lemon_empty_glass
        }
    }

    Column(
        modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(text), fontSize = 18.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Image(painter = painterResource(imageResource),
            contentDescription = num.toString(),
            modifier = Modifier
                .size(250.dp)
                .border(
                    3.dp, Color(105, 205, 216, 255), shape = RoundedCornerShape(15.dp)
                )
                .clickable {
                    if (num == 1) {
                        val rand = (0 until 10).random()
                        if (rand > 4) num++
                    } else num = (num + 1) % 4
                    println("Button Clicked! $num")
                })
    }
}


