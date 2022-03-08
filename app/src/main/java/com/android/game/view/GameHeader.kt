package com.android.game.view

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.android.game.backend.models.Level

@OptIn(ExperimentalAnimationApi::class)
@Composable
internal fun ColumnScope.GameHeader(level: Level, modifier: Modifier = Modifier) {
    var revealing by remember(level) { mutableStateOf(false) }
    GameHeader(modifier) {

    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
internal fun ColumnScope.GameHeader(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    val context = LocalContext.current
    Column(modifier
        .align(Alignment.CenterHorizontally)) {

        Text(text = "Assessment",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Black,
            fontFamily = FontFamily.Serif,
            modifier = Modifier.align(
                Alignment.CenterHorizontally))
        Spacer(Modifier.size(4.dp))
        Text(text = "1. Green for correct letter at the correct spot.",
            fontWeight = FontWeight.Light,
            fontFamily = FontFamily.Serif,
            modifier = Modifier.align(
                Alignment.Start))
        Spacer(Modifier.size(4.dp))
        Text(text = "2. Yellow for the correct letter but at the wrong spot.",
            fontWeight = FontWeight.Light,
            fontFamily = FontFamily.Serif,
            modifier = Modifier.align(
                Alignment.Start))
        Spacer(Modifier.size(4.dp))
        Text(text = "3. Gray for the wrong letter.",
            fontWeight = FontWeight.Light,
            fontFamily = FontFamily.Serif,
            modifier = Modifier.align(
                Alignment.Start))
        content()

    }
}
