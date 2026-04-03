package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {

            CreateTitle()
            CenteredMenu()
            CreateActiveButton {
                println("Hello User Working...")
            }
        }
    }

    @Composable
    fun CreateTitle() {
        Box(
            contentAlignment = Center
        ) {
            Text(
                "About-Me Application",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(top = (25.dp * 2) * 4),
                fontSize = (((13.sp * 2)))
            )
        }
    }

    @Composable
    fun CreateActiveButton(onClicking:() -> Unit) {
        Column (
            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(
                onClick = { onClicking() },
                modifier = Modifier.size(width = 400.dp / 2, height = 85.dp / 2)
            ) {
                Text(
                    "Get Info from Me"
                )
            }
        }
    }

    @Composable
    fun CenteredMenu() {
        Box(
            contentAlignment = Center,
        ) {
            Text(
                text = "Hello I am Ryan James | Android Developer",
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Medium,
                fontSize = 35.sp / 2,
                modifier = Modifier.fillMaxWidth().padding(top = 500.dp / 2),
                color = Color.Black
            )
        }
    }
}

