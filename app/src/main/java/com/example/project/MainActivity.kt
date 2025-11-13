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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.offset
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
    var clicks by rememberSaveable { mutableIntStateOf(0) }
    val addClick: () -> Unit = { clicks++ }
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 50.dp, vertical = 30.dp)
    ){
        Box(modifier = Modifier
            .width(100.dp)
            .align(Alignment.Center)
            .aspectRatio(1f)
            .background(color = colorResource(R.color.white))
            .clickable{addClick()}
        ){
            Icon(
                painter = painterResource(R.drawable.dognose),
                contentDescription = null
            )
        }
        Text(
            text = clicks.toString(),
            fontSize = 30.sp,
            modifier = Modifier
                    .align(Alignment.TopEnd)
        )
        Icon(
            painter = painterResource(R.drawable.eye),
            contentDescription = null,
            modifier = Modifier
                .size(30.dp)
                .offset(x = 80.dp, y = 280.dp)
        )
        Icon(
            painter = painterResource(R.drawable.eye),
            contentDescription = null,
            modifier = Modifier
                .size(30.dp)
                .offset(x = 225.dp, y = 280.dp)
        )
        Icon(
            painter = painterResource(R.drawable.smile3),
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
                .offset(x = 100.dp, y = 410.dp)
        )
        Icon(
            painter = painterResource(R.drawable.ear2),
            contentDescription = null,
            modifier = Modifier
                .size(300.dp)
                .offset(x = 15.dp, y = 20.dp)
        )



    }
}
@Preview(showBackground = true)
@Composable
fun MyScreenPreview() {

    MyScreen()

}