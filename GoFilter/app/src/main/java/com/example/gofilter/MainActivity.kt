package com.example.gofilter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.gofilter.app.GoFilterApp
import jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoFilterApp()
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    GoFilterApp()
}