package com.captainapps.wordz.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.captainapps.wordz.R
import com.captainapps.wordz.backend.models.Level

@OptIn(ExperimentalAnimationApi::class)
@Composable
internal fun ColumnScope.GameHeader(level: Level, modifier: Modifier = Modifier) {
    var revealing by remember(level) { mutableStateOf(false) }
    GameHeader(modifier) {
        LevelHeaderContent(level, revealing) {
            revealing = it
        }
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
        .clickable {

            context.startActivity(Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("http://www.github.com/adibfara/Faradle/")
            })
        }
        .align(Alignment.CenterHorizontally)) {

        Text(text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Black,
            fontFamily = FontFamily.Serif,
            modifier = Modifier.align(
                Alignment.CenterHorizontally))
        Text(text = "github.com/adibfara/faradle",
            style = MaterialTheme.typography.bodySmall,
            fontSize = 10.sp,
            modifier = Modifier.align(
                Alignment.CenterHorizontally))
        content()

    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun ColumnScope.LevelHeaderContent(
    level: Level,
    revealing: Boolean,
    onRevealChanged: (Boolean) -> Unit,
) {
    Row(
        modifier = Modifier.Companion
            .align(
                Alignment.CenterHorizontally)
            .padding(top = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Level ${level.number}",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Black,
            fontFamily = FontFamily.Serif,
        )
        Box(modifier = Modifier.padding(start = 16.dp)) {
            if (!revealing) {
                Text(text = "(reveal)",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.clickable {
                        onRevealChanged(true)
                    })
            } else {
                Text(text = level.word.word, style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary,

                    modifier = Modifier.clickable {
                        onRevealChanged(false)
                    })
            }
        }

    }
}