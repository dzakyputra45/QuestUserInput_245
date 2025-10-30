package com.example.questuserinput_245

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.questuserinput_245.ui.theme.QuestUserInput_245Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuestUserInput_245Theme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    // tampilkan layout data diri
                    FormatDataDiri()
                }
            }
        }
    }
}
