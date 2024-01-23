package com.quran.mobile.feature.audiobar.ui

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.quran.labs.androidquran.common.ui.core.QuranIcons
import com.quran.labs.androidquran.common.ui.core.QuranTheme
import com.quran.mobile.feature.audiobar.AudioBarEvent
import com.quran.mobile.feature.audiobar.AudioBarState

@Composable
fun StoppedAudioBar(state: AudioBarState.Stopped, modifier: Modifier = Modifier) {
  val sink = state.eventSink
  Row(
    verticalAlignment = Alignment.CenterVertically,
    modifier = modifier.height(IntrinsicSize.Min)
  ) {
    IconButton(onClick = { sink(AudioBarEvent.StoppedPlaybackEvent.Play) }) {
      Icon(QuranIcons.PlayArrow, contentDescription = "")
    }

    Divider(
      modifier = Modifier
        .fillMaxHeight()
        .width(Dp.Hairline)
    )

    TextButton(
      modifier = Modifier.weight(1f),
      onClick = { sink(AudioBarEvent.StoppedPlaybackEvent.ChangeQari) }
    ) {
      Text(text = state.qariName)
      Spacer(modifier = Modifier.weight(1f))
      Icon(QuranIcons.ExpandMore, contentDescription = "")
    }

    if (state.enableRecording) {
      Divider(
        modifier = Modifier
          .fillMaxHeight()
          .width(Dp.Hairline)
      )

      IconButton(onClick = { sink(AudioBarEvent.StoppedPlaybackEvent.Record) }) {
        Icon(QuranIcons.Mic, contentDescription = "")
      }
    }
  }
}

@Preview
@Composable
fun StoppedAudioBarPreview() {
  QuranTheme {
    StoppedAudioBar(
      state = AudioBarState.Stopped(
        qariName = "Qari Name",
        enableRecording = false,
        eventSink = {}
      )
    )
  }
}

@Preview
@Composable
fun StoppedAudioBarWithRecordingPreview() {
  QuranTheme {
    StoppedAudioBar(
      state = AudioBarState.Stopped(
        qariName = "Qari Name",
        enableRecording = true,
        eventSink = {}
      )
    )
  }
}
