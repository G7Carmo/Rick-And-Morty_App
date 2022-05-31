package com.gds.rickmortyapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gds.rickmortyapp.data.model.episodeos.EpisodeResult
import com.gds.rickmortyapp.data.model.localizacao.LocationResult
import com.gds.rickmortyapp.databinding.ActivityCharacterBinding
import com.gds.rickmortyapp.databinding.ActivityEpisodeBinding
import com.gds.rickmortyapp.databinding.ActivityLocationBinding

class EpisodeAdapter(
    val list: List<EpisodeResult>
) : RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder>() {
    inner class EpisodeViewHolder(val binding: ActivityEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        return EpisodeViewHolder(
            ActivityEpisodeBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            )
        )
    }
    override fun getItemCount() = list.size
    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {

    }
}