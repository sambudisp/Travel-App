package com.sambudisp.travelapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sambudisp.travelapp.databinding.ItemTopDestinationBinding
import com.sambudisp.travelapp.model.DestinationModel

class TopDestinationAdapter(
    private val list: List<DestinationModel>
) : RecyclerView.Adapter<TopDestinationHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): TopDestinationHolder {
        val binding = ItemTopDestinationBinding.inflate(
            LayoutInflater.from(p0.context),
            p0,
            false
        )
        return TopDestinationHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(p0: TopDestinationHolder, p1: Int) {
        p0.bind(list[p1])
    }
}

class TopDestinationHolder(val binding: ItemTopDestinationBinding) :
    RecyclerView.ViewHolder(binding.root) {
    private val image = binding.ivPlace
    private val placeName = binding.tvPlaceName
    private val placeDetail = binding.tvPlaceDetail
    private val thisContext = itemView.context

    fun bind(data: DestinationModel) {
        //image.setImageDrawable()

        placeName.text = data.name
        placeDetail.text = data.detail
    }
}