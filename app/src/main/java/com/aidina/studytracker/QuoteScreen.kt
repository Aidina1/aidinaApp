package com.aidina.studytracker

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun QuoteScreen(onBack: () -> Unit) {
    val quotes = listOf(
        "The secret of getting ahead is getting started.",
        "Don't watch the clock; do what it does. Keep going.",
        "Success is the sum of small efforts repeated day in and day out.",
        "Believe you can and you're halfway there.",
        "It always seems impossible until it's done."
    )

    var currentQuote by remember { mutableStateOf(quotes.random()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Daily Quote",
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = currentQuote,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(24.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { currentQuote = quotes.random() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("New Quote")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back to Home")
        }
    }
}