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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project.ui.theme.ProjectTheme

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
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 30.dp, vertical = 30.dp)
    ){
        Box(modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .background(color = colorResource(R.color.middle_button))
            .clickable{


            }
        ){
            Text(
                text="5",
                color = colorResource( R.color.purple_700),
                fontSize = 30.sp,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }


    }
}
@Preview(showBackground = true)
@Composable
fun MyScreenPreview() {
    MyScreen()
}