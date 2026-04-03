package com.example.myapplication

import android.R.attr.letterSpacing
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
import java.util.Calendar

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
            GetDateNow()
            DayOfTime()

            CreateActiveButton {
                println("Hello User Working...")
            }

            BottomDropButton {
                println("Working...")
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
                modifier = Modifier.fillMaxWidth().padding(top = (24.dp * 2) * 4),
                textAlign = TextAlign.Center,
                fontSize = ((15.sp * 2) / 2)
            )

        }
    }


    @Composable
    fun BottomDropButton(click: () -> Unit) {

        Column(

            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Button(

                onClick = { click() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White,
                ),

                modifier = Modifier.padding(top = 800.dp)
                    .size(width = 700.dp / 2, height = 85.dp / 2)
            ) {
                Text(
                    "Next Page",
                    textAlign = TextAlign.Center,
                    fontSize = ((15.sp * 2) / 2)
                )
            }
        }
    }

    @Composable
    fun DayOfTime() {
        val timeNowHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)

        if (timeNowHour.dp < 11.dp) {

            Box(
                contentAlignment = Center
            ) {

                Text(
                    "Good Morning",
                    modifier = Modifier.fillMaxWidth().padding(top = (15.dp * 2) * 4),
                    textAlign = TextAlign.Center,
                    fontSize = ((15.sp * 2) / 2)
                )
            }
        } else if (timeNowHour.dp > 11.dp) {

            Box(
                contentAlignment = Center
            ) {

                Text(
                    "Good Afternoon",
                    modifier = Modifier.fillMaxWidth().padding(top = (15.dp * 2) * 4),
                    textAlign = TextAlign.Center,
                    fontSize = ((15.sp * 2) / 2)
                )
            }

        } else if (timeNowHour.dp > 16.dp) {

            Box(
                contentAlignment = Center
            ) {

                Text(
                    "Good Evening",
                    modifier = Modifier.fillMaxWidth().padding(top = (15.dp * 2) * 4),
                    textAlign = TextAlign.Center,
                    fontSize = ((15.sp * 2) / 2)
                )
            }

        }
    }

    @Composable
    fun WelcomeUserMessage() {

        val textUpper = UpperTextMethod()

        Box(
            contentAlignment = Center
        ) {
            Text(
                textUpper.getTextValue("Welcome Everyone..."),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(top = (10.dp * 2) * 4),
                fontSize = (((12.sp * 2))),
                letterSpacing = TextUnit(4f, TextUnitType.Sp),
                fontWeight = FontWeight.Bold
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
                fontSize = ((9.sp * 2)),
                letterSpacing = TextUnit(2f, TextUnitType.Sp)
            )
        }
    }

    @Composable
    fun CreateActiveButton(onClicking: () -> Unit) {
        Column(
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
                modifier = Modifier.padding(top = 650.dp)
                    .size(width = 700.dp / 2, height = 85.dp / 2)
            ) {
                Text(
                    "Get Info from Me"
                )
            }
        }
    }
}


/*

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

*/
