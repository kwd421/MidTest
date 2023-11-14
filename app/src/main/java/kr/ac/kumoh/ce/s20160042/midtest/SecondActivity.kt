package kr.ac.kumoh.ce.s20160042.midtest

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import kr.ac.kumoh.ce.s20160042.midtest.ui.theme.MidTestTheme

class SecondActivity : ComponentActivity() {
    companion object {
        const val BUTTON_PRESSED = "ButtonPressed"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MidTestTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    when (intent.getIntExtra(
                        MainActivity.GROZA_KEY,
                        MainActivity.GROZA_NONE)) {
                        MainActivity.GROZA_IMAGE -> GrozaImage()
                        MainActivity.GROZA_BUTTON -> GrozaButton()
                            else -> finish()
                    }
                }
            }
        }
    }
}

@Composable
fun GrozaImage() {
    Image(painter = painterResource(id = R.drawable.groza),
        contentDescription = "Groza Image")
}


@Composable
fun GrozaButton() {
    val activity = LocalContext.current as Activity
    Button(onClick = {
        val result = Intent()
        result.putExtra(SecondActivity.BUTTON_PRESSED, true)
        activity.setResult(RESULT_OK, result)
        activity.finish()
    }) {
        Text("Groza")
    }
}