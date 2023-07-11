package com.example.kotlinproject.Activity

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.MediaController
import android.widget.VideoView
import com.example.kotlinproject.R
import kotlinx.android.synthetic.main.activity_video_payer.*

class VideoPayerActivity : AppCompatActivity() {

    private var mediaController: MediaController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_payer)

        val videoView = findViewById<VideoView>(R.id.videoView)

        val msg = intent.getStringExtra("dd")

        val videoPath = "http://16.16.91.234:3003/uploads/1683618677319.mp4"
        videoView.setVideoPath(videoPath)
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)
        videoView.start()
    }
}