package com.example.sabak9rcyclerviewretrofitglide

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sabak9rcyclerviewretrofitglide.data.Amiibo
import com.example.sabak9rcyclerviewretrofitglide.databinding.ExampleAmiiboBinding
import retrofit2.Retrofit

class AmiiboAdapter:RecyclerView.Adapter<AmiiboAdapter.AmiiboHolder>() {
    private val amiibolist = mutableListOf<Amiibo>()
    inner class AmiiboHolder(private val binding: ExampleAmiiboBinding):RecyclerView.ViewHolder(binding.root){
        fun onBind(amiiboItem:Amiibo){
            binding.txtAmiiboName.text = amiiboItem.name
            binding.txtAmiiboKey.text = amiiboItem.key
        }
    }
    fun submitAmiiboList(list: List<Amiibo>){
        amiibolist.clear()
        amiibolist.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AmiiboAdapter.AmiiboHolder {
        return AmiiboHolder(
            ExampleAmiiboBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        )
    }

    override fun getItemCount(): Int {
            return amiibolist.size
    }

    override fun onBindViewHolder(holder: AmiiboHolder, position: Int) {
        holder.onBind(amiibolist[position])
    }
}