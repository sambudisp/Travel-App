package com.sambudisp.travelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.sambudisp.travelapp.databinding.ActivityDetailBinding
import com.sambudisp.travelapp.model.DestinationModel

class DetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        getParcelableExtra()
        setupButton()
    }

    private fun setupButton() {
        val animation = AnimationUtils.loadAnimation(this, R.anim.circle_explotion_animation).apply {
            duration = 700
            interpolator = AccelerateDecelerateInterpolator()
        }

        with(binding){
            ivBack.setOnClickListener {
                finish()
            }
        }
    }

    private fun setupView() {
        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }

    private fun getParcelableExtra(){
        val data = intent.getParcelableExtra<DestinationModel>("extra_data")

        with(binding){
            ivImage.setImageResource(data?.image!!)
            tvPlaceName.text = data?.name
            tvPlaceDetail.text = data?.detail
            tvPrice.text = data?.price
            tvRating.text = data?.rating
        }

    }
}