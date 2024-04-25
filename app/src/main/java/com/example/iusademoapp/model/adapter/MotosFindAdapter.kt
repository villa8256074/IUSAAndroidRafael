package com.example.iusademoapp.model.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.iusademoapp.R
import com.example.iusademoapp.databinding.FragmentSecondBinding
import com.example.iusademoapp.databinding.ItemMotosFindBinding
import com.example.iusademoapp.model.response.MotoDAO

class MotosFindAdapter(val motos: List<MotoDAO>) : RecyclerView.Adapter<MotosFindAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ItemMotosFindBinding.bind(view)

        fun bind(moto: MotoDAO) {
            binding.title.text = buildString {
                append(binding.title.text.toString())
                append(" ")
                append(moto.idMoto)
            }
            binding.textViewMoto.text = moto.moto
            binding.textViewBateriaOne.text = moto.bateria1
            binding.textViewBateriaTwo.text = moto.bateria2
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_motos_find, parent, false))
    }

    override fun getItemCount(): Int {
        return motos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = motos[position]
        holder.bind(item)
    }

}