package com.sambudisp.travelapp

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sambudisp.travelapp.databinding.ActivityMainBinding
import com.sambudisp.travelapp.model.DestinationModel

class MainActivity : AppCompatActivity(), RecommendationListener {

    private lateinit var binding: ActivityMainBinding

    private val listOfRecommendation = mutableListOf<DestinationModel>()
    private var recommendationAdapter = RecommendationAdapter(listOfRecommendation, this)

    private val listOfTopDestination = mutableListOf<DestinationModel>()
    private var topDestinationAdapter = TopDestinationAdapter(listOfTopDestination)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        with(binding) {
            rvRecommendation.apply {
                layoutManager = LinearLayoutManager(
                    context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                adapter = recommendationAdapter
            }

            rvTopDestination.apply {
                layoutManager = LinearLayoutManager(
                    context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                adapter = topDestinationAdapter
            }
        }

        for (i in 0 until 3) {
            listOfRecommendation.add(
                DestinationModel(
                    R.drawable.img_sample,
                    "Torii Gate",
                    "Kyoto, Japan",
                    "$120",
                    "4.9"
                )
            )
            listOfRecommendation.add(
                DestinationModel(
                    R.drawable.img_sample,
                    "Fuji Mountain",
                    "Shizouka, Japan",
                    "$320",
                    "4.0"
                )
            )
            listOfRecommendation.add(
                DestinationModel(
                    R.drawable.img_sample,
                    "National Monument",
                    "Jakarta, Indonesia",
                    "$10",
                    "4.5"
                )
            )
        }
        recommendationAdapter.notifyDataSetChanged()

        for (i in 0 until 3) {
            listOfTopDestination.add(
                DestinationModel(
                    R.drawable.img_sample,
                    "Torii Gate",
                    "Kyoto, Japan",
                    "$120",
                    "4.9"
                )
            )
            listOfTopDestination.add(
                DestinationModel(
                    R.drawable.img_sample,
                    "Fuji Mountain",
                    "Shizouka, Japan",
                    "$320",
                    "4.0"
                )
            )
            listOfTopDestination.add(
                DestinationModel(
                    R.drawable.img_sample,
                    "National Monument",
                    "Jakarta, Indonesia",
                    "$10",
                    "4.5"
                )
            )
        }
        topDestinationAdapter.notifyDataSetChanged()
    }

    private fun setupView() {
        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }

    override fun onClicked(data: DestinationModel) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("extra_data", data)
        startActivity(intent)
    }
}