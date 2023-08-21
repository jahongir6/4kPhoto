package com.example.a4krasmlar

import android.annotation.SuppressLint
import android.app.WallpaperManager
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Paint
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.core.graphics.drawable.toBitmap
import com.example.a4krasmlar.databinding.ActivityShowMainBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class ShowMainActivity : AppCompatActivity(), View.OnClickListener {
    private var imageId = R.drawable.img3
    private var btnLikeStateChecked = false
    private lateinit var binding: ActivityShowMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = ActivityShowMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        imageId = intent.getIntExtra("id", R.drawable.img3)
        binding.image.setImageResource(imageId)



        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        binding.btnBack.setOnClickListener(this)
        binding.btnLike.setOnClickListener(this)
    }

    @SuppressLint("ResourceType")
    override fun onClick(p0: View?) {
        when (p0?.id) {
            binding.btnBack.id -> {
                finish()
            }
            binding.btnLike.id -> {
                btnLikeStateChecked = if (!btnLikeStateChecked) {
                    binding.btnLike.setImageResource(R.drawable.nav_menu_liked)
                    true
                } else {
                    binding.btnLike.setImageResource(R.drawable.bottom_icon_like)
                    false
                }
            }

        }


    }
}