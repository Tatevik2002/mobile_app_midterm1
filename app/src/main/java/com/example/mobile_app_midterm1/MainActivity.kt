package com.example.mobile_app_midterm1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobile_app_midterm1.ui.theme.Mobile_app_midterm1Theme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
//import androidx.compose.foundation.gestures.detectTransformations
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { GameScreen()}
    }
}
@Composable
fun GameScreen() {
    var currentScore = 0
    var target by remember { mutableStateOf(Random.nextInt(0, 101)) }
    val minRange = 0
    val maxRange = 100
    var sliderValue by remember  { mutableStateOf((minRange + maxRange) / 2) }

    fun score(number: Int, target :Int): Int{
        if (number < target+3 && number >target-3) return 5
        if (number < target+8 && number >target-8) return 1
        return 0

    }

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Bull's Eye Game")

        Spacer(modifier = Modifier.height(20.dp))

        Text("Move the slider  as close as you can to: $target")

        Spacer(modifier = Modifier.height(20.dp))

        Slider(
            value = sliderValue.toFloat(),
            onValueChange = { newValue -> sliderValue = newValue.toInt() },
            valueRange = minRange.toFloat()..maxRange.toFloat()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                println(sliderValue)
                currentScore = score(sliderValue.toInt(),target)+ currentScore
                var target = Random.nextInt(minRange, maxRange)
                sliderValue =  (minRange + maxRange) / 2
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Hit me!")
        }



        Spacer(modifier = Modifier.height(20.dp))

        Text("Your Score: $currentScore")
    }



}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Mobile_app_midterm1Theme {
        Greeting("Android")
    }
}