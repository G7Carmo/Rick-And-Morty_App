package com.gds.rickmortyapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gds.rickmortyapp.data.model.localizacao.LocationResult
import com.gds.rickmortyapp.databinding.ActivityCharacterBinding
import com.gds.rickmortyapp.databinding.ActivityLocationBinding

class LocationAdapter(
    val list: List<LocationResult>
) : RecyclerView.Adapter<LocationAdapter.LocationViewHolder>() {
    inner class LocationViewHolder(val binding: ActivityLocationBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        return LocationViewHolder(
            ActivityLocationBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
    }
}