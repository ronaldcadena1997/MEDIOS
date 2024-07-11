package com.proyecto.medios

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.proyecto.medios.R.id

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Configurar el VideoView
        val videoView = findViewById<VideoView>(id.videoView)
        val videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.karonvideo3)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        videoView.setMediaController(mediaController)
        videoView.setVideoURI(videoUri)
        videoView.requestFocus()
        videoView.start()

        // Configurar el botón
        val button = findViewById<Button>(id.button)
        button.setOnClickListener {
            val intent = Intent(this, Pantalla2::class.java)
            startActivity(intent)
        }

    }
}