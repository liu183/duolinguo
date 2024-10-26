package com.example.languagelearningapp.util

import android.content.Context
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AudioPlayerManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private var exoPlayer: ExoPlayer? = null

    fun initializePlayer() {
        exoPlayer = ExoPlayer.Builder(context).build()
    }

    fun playAudio(url: String) {
        exoPlayer?.let { player ->
            val mediaItem = MediaItem.fromUri(url)
            player.setMediaItem(mediaItem)
            player.prepare()
            player.play()
        }
    }

    fun pauseAudio() {
        exoPlayer?.pause()
    }

    fun resumeAudio() {
        exoPlayer?.play()
    }

    fun releasePlayer() {
        exoPlayer?.release()
        exoPlayer = null
    }

    fun setPlaybackStateListener(listener: Player.Listener) {
        exoPlayer?.addListener(listener)
    }
}
