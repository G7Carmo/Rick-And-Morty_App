package com.gds.rickmortyapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gds.rickmortyapp.data.model.localizacao.LocationResult
import com.gds.rickmortyapp.databinding.ActivityCharacterBinding

class CharacterAdapter(
    val list: List<CharacterAdapter>
) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {
    inner class CharacterViewHolder(val binding: ActivityCharacterBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            ActivityCharacterBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
    }
}