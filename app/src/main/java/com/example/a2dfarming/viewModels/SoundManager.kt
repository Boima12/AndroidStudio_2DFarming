package com.example.a2dfarming.viewModels

import android.app.Application
import android.media.MediaPlayer
import android.media.SoundPool
import androidx.annotation.RawRes
import androidx.lifecycle.AndroidViewModel
import com.example.a2dfarming.R


class SoundManager(application: Application) : AndroidViewModel(application) {
    private val app = application
    private var mediaPlayer: MediaPlayer? = null
    private var currentResId: Int? = null

    private var soundPool: SoundPool? = null
    private val sfxMap = mutableMapOf<Int, Int>()
    private val loadedSoundIds = mutableSetOf<Int>()
    init {
        soundPool = SoundPool.Builder().setMaxStreams(5).build()
        preloadSfx(R.raw.place_crop)
    }

    private fun preloadSfx(@RawRes resId: Int) {
        val id = soundPool?.load(app, resId, 1) ?: return
        sfxMap[resId] = id
        soundPool?.setOnLoadCompleteListener { _, loadedId, status ->
            if (status == 0 && loadedId == id) {
                loadedSoundIds.add(resId)
            }
        }
    }

    fun playSfx(@RawRes resId: Int, volume: Float = 1f) {
        val pool = soundPool ?: return
        if (loadedSoundIds.contains(resId)) {
            val soundId = sfxMap[resId] ?: return
            pool.play(soundId, volume, volume, 1, 0, 1f)
            return
        }
        // Load and cache
        val soundId = pool.load(app, resId, 1)
        sfxMap[resId] = soundId
        pool.setOnLoadCompleteListener { _, loadedId, status ->
            if (status == 0 && loadedId == soundId) {
                loadedSoundIds.add(resId)
                pool.play(soundId, volume, volume, 1, 0, 1f)
            }
        }
    }


    fun playTrack(@RawRes resId: Int) {
        // If the same track is already playing, do nothing
        if (mediaPlayer != null && mediaPlayer?.isPlaying == true && currentResId == resId) return

        mediaPlayer?.release()
        mediaPlayer = MediaPlayer.create(app, resId).apply {
            isLooping = true
            setVolume(1f, 1f)
            start()
        }
        currentResId = resId
    }

    fun stopTrack() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
        currentResId = null
    }

    override fun onCleared() {
        super.onCleared()
        mediaPlayer?.release()
        soundPool?.release()
    }
}