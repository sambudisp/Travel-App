package com.sambudisp.travelapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sambudisp.travelapp.databinding.ItemRecommendationBinding
import com.sambudisp.travelapp.model.DestinationModel

class RecommendationAdapter(
    private val list: List<DestinationModel>,
    private val listener: RecommendationListener
) : RecyclerView.Adapter<RecommendationHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecommendationHolder {
        val binding = ItemRecommendationBinding.inflate(
            LayoutInflater.from(p0.context),
            p0,
            false
        )
        return RecommendationHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(p0: RecommendationHolder, p1: Int) {
        p0.bind(list[p1], listener)
    }
}

class RecommendationHolder(val binding: ItemRecommendationBinding) :
    RecyclerView.ViewHolder(binding.root) {
    private val image = binding.ivPlace
    private val price = binding.tvPrice
    private val placeName = binding.tvPlaceName
    private val placeDetail = binding.tvPlaceDetail
    private val thisContext = itemView.context

    fun bind(data: DestinationModel, listener: RecommendationListener) {
        image.setImageResource(data.image)

        price.text = data.price
        placeName.text = data.name
        placeDetail.text = data.detail

        itemView.setOnClickListener {
            listener.onClicked(data)
        }
    }
}

interface RecommendationListener {
    fun onClicked(data: DestinationModel)
}