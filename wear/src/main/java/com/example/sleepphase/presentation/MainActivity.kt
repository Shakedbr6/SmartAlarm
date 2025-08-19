/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter to find the
 * most up to date changes to the libraries and their usages.
 */

package com.example.sleepphase.presentation

import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.sleepphase.presentation.theme.SleepPhaseTheme
import androidx.wear.tooling.preview.devices.WearDevices
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Arrangement
import androidx.wear.compose.material.MaterialTheme
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.ui.text.style.TextAlign
import androidx.wear.compose.material.TimeText
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.background
import androidx.compose.ui.res.stringResource
import androidx.compose.runtime.MutableState
import androidx.wear.compose.material.Button
import androidx.activity.compose.setContent
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.wear.compose.material.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sleepphase.R
import android.os.Bundle
import android.util.Log


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)//check what's happening without this line
        installSplashScreen()
        Log.d("MainActivity", "Hi logcat")
        Log.d("MainActivity", "Omggg")

        setTheme(android.R.style.Theme_DeviceDefault)// setting initial design settings
        setContent {
            val counter = remember { mutableIntStateOf(0) }
            TestMessage(counter)/*WearApp("Android")*/
        }
    }
}


@Composable
fun TestMessage(msg: MutableState<Int>) {
    SleepPhaseTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = "Welcome to my app :)\n clicking counter: ${msg.value}",
                    color = Color.Green
                )

                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        Log.d("MyApp", "Button clicked!!!")
                        msg.value++

                    }
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(), text = "Click"

                    )
                }
            }
        }
    }
}


@Composable
fun WearApp(greetingName: String) {
    SleepPhaseTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            contentAlignment = Alignment.Center
        ) {
            TimeText()
            Greeting(greetingName = greetingName)
        }
    }
}


@Composable
fun Greeting(greetingName: String) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        color = MaterialTheme.colors.primary,
        text = stringResource(R.string.hello_world, greetingName)
    )
}


@Preview(device = WearDevices.SMALL_ROUND, showSystemUi = true)
@Composable
fun DefaultPreview() {
    WearApp("Preview Android")
}
