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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate

class UpperTextMethod {

    fun getTextValue(textValue:String): String {

        return textValue.uppercase()
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {

            WelcomeUserMessage()
            CreateTitle()
            CenteredMenu()
            GetDateNow()
            CreateActiveButton {
                println("Hello User Working...")
            }
        }
    }

    @Composable
    fun GetDateNow() {
        val dateNow: LocalDate = LocalDate.now()
        Box(
            contentAlignment = Center
        ) {
          Text(

              "Today's Date: $dateNow",
              modifier = Modifier.fillMaxWidth().padding(top = (29.dp * 2) * 4),
              textAlign = TextAlign.Center,
              fontSize = ((15.sp * 2) / 2)
          )

        }
    }


    @Composable
    fun WelcomeUserMessage() {
        Box(
            contentAlignment = Center
        ) {
            Text(
                "Welcome Everyone...",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(top = (10.dp * 2) * 4),
                fontSize = (((13.sp * 2))),
                letterSpacing = TextUnit(4f, TextUnitType.Sp)

            )
        }

    }

    @Composable
    fun CreateTitle() {

        val textUpper = UpperTextMethod()

        Box(
            contentAlignment = Center
        ) {
            Text(
                textUpper.getTextValue("About-Me Application"),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(top = (20.dp * 2) * 4),
                fontSize = (((7.5.sp * 2))),
                letterSpacing = TextUnit(2f, TextUnitType.Sp)
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
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White,
                ),
                modifier = Modifier.padding(bottom = 190.dp).size(width = 700.dp / 2, height = 85.dp / 2)
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
                text = "I am Ryan James | Android Developer",
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Medium,
                fontSize = 30.sp / 2,
                modifier = Modifier.fillMaxWidth().padding(top = 400.dp / 2),
                color = Color.Black
            )
        }
    }
}

