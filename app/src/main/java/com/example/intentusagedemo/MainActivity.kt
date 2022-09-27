package com.example.intentusagedemo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentusagedemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnShowImage.setOnClickListener {

            var intent = Intent("in.bitcode.media.VIEW")
            intent.setDataAndType(
                Uri.parse(binding.edtPath.text.toString()),
                "image/jpeg"
            )

            startActivity(intent)
        }

        binding.btnVideo.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(
                Uri.parse(binding.edtPath.text.toString()),
                "video/mp4"
            )
            startActivity(intent)
        }


        binding.btnAudio.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(
                Uri.parse(binding.edtPath.text.toString()),
                "audio/mp3"
            )
            startActivity(intent)
        }

        binding.btnShare.setOnClickListener {
            var intent = Intent(Intent.ACTION_SEND)
            intent.setDataAndType(
                Uri.parse(binding.edtPath.text.toString()),
                "image/jpeg"
            )
            startActivity(intent)
        }

        binding.btnCall.setOnClickListener {
            var intent = Intent(Intent.ACTION_CALL)
            intent.setData(
                Uri.parse(binding.edtPath.text.toString())
            )
            startActivity(intent)
        }

        binding.btnWeb.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW)
            intent.setData(
                Uri.parse(binding.edtPath.text.toString())
            )
            startActivity(intent)
        }

        binding.btnPickImage.setOnClickListener {
            var intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"

            startActivityForResult(intent,1)
        }
    }
}