package com.example.project

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project.ui.theme.ProjectTheme
import androidx.compose.material3.Icon
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.remember
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay
import androidx.compose.foundation.border
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.mutableStateOf
import kotlin.random.Random
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyScreenPreview()
        }
    }
}

@Composable
private fun MyScreen(){
    var default by remember { mutableStateOf(2) }
    var w by remember { mutableStateOf(2.dp) }
    var ww by remember { mutableStateOf(2.dp) }
    var nclick by remember{mutableStateOf(true)}
    var pressed by remember{mutableStateOf(false)}
    var ratio by rememberSaveable { mutableIntStateOf(2) }
    var clicks by rememberSaveable { mutableIntStateOf(0) }
    val addClick: (Int) -> Unit = { x->clicks=clicks+x }
    var boostTime by rememberSaveable { mutableIntStateOf(0) }
    var autoTime by rememberSaveable { mutableIntStateOf(0) }

    LaunchedEffect(boostTime) {
        if (boostTime > 0) {
            delay(1000)
            boostTime--

            if (boostTime == 0) {
                ratio = default
            }
        }
    }
    LaunchedEffect(autoTime) {
        while (autoTime > 0) {
            delay(1000)
            addClick(ratio)
        }
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 50.dp, vertical = 30.dp)
    ){
        Box(modifier = Modifier
            .width(60.dp)
            .align(Alignment.Center)
            .aspectRatio(1f)
            .background(color = colorResource(R.color.white))
            .clickable{addClick(ratio)}
        ){
            Icon(
                painter = painterResource(R.drawable.dognose),
                contentDescription = null
            )
        }
        Box(modifier = Modifier
            .width(100.dp)
            .align(Alignment.BottomCenter)
            .aspectRatio(1f)
            .border(2.dp, Color.Black)
            .clickable{
                clicks=clicks - 50
                ratio = default*2
                boostTime=10
            }
        ){
            Text(
                text="  x2",
                fontSize = 50.sp,
                modifier = Modifier
                    .align(Alignment.CenterStart)
            )

        }
        Box(modifier = Modifier
            .width(100.dp)
            .align(Alignment.BottomStart)
            .aspectRatio(1f)
            .border(ww, Color.Black)
            .clickable{
                if (nclick) {
                    ratio = Random.nextInt(1, 10)
                    nclick = false
                    ww=5.dp
                }
            }
        ){
            Text(
                text="Ratio",
                fontSize = 30.sp,
                modifier = Modifier
                    .align(Alignment.Center)
            )

        }
        Box(modifier = Modifier
            .width(100.dp)
            .align(Alignment.BottomEnd)
            .border(w, Color.Black)
            .aspectRatio(1f)
            .clickable{
                if(pressed){
                    ratio = default
                    w=2.dp
                    pressed = false
                    autoTime=0
                }else{
                    ratio = 1
                    w=5.dp
                    pressed = true
                    autoTime=1
                }

            }
        ){
            Text(
                text="  Auto",
                fontSize = 30.sp,
                modifier = Modifier
                        .align(Alignment.CenterStart)
            )

        }
        Text(
            text = clicks.toString(),
            fontSize = 30.sp,
            modifier = Modifier
                    .align(Alignment.TopEnd)
        )
        val dogPainter = if (ratio == default*2)
            painterResource(R.drawable.angrydog)
        else
            painterResource(R.drawable.dog)


        Icon(
            painter =dogPainter,
            contentDescription = null,
            modifier = Modifier
                .size(300.dp)
                .offset(x =0.dp, y = 200.dp)
        )




    }
}
@Preview(showBackground = true)
@Composable
fun MyScreenPreview() {

    MyScreen()

}