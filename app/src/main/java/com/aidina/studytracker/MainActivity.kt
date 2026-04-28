package com.aidina.studytracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aidina.studytracker.ui.theme.StudyTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudyTrackerTheme {
                AppNavigator()
            }
        }
    }
}

@Composable
fun AppNavigator() {
    var currentScreen by remember { mutableStateOf("home") }

    when (currentScreen) {
        "home" -> HomeScreen(
            onGoToTracker = { currentScreen = "tracker" },
            onGoToQuote = { currentScreen = "quote" }
        )
        "tracker" -> StudyTrackerScreen(onBack = { currentScreen = "home" })
        "quote" -> QuoteScreen(onBack = { currentScreen = "home" })
    }
}

@Composable
fun HomeScreen(onGoToTracker: () -> Unit, onGoToQuote: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Welcome, Aidina!", fontSize = 32.sp)

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Your personal study companion", fontSize = 16.sp)

        Spacer(modifier = Modifier.height(48.dp))

        Button(
            onClick = onGoToTracker,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Study Tracker")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onGoToQuote,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Daily Quote")
        }
    }
}