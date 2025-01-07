package com.example.sabak9rcyclerviewretrofitglide

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideType
import com.example.sabak9rcyclerviewretrofitglide.data.Meme
import com.example.sabak9rcyclerviewretrofitglide.databinding.ExampleAdapterBinding
import com.example.sabak9rcyclerviewretrofitglide.databinding.FragmentFirstBinding

class rcViewAdapter:RecyclerView.Adapter<rcViewAdapter.ExampleViewHolder>(){
    private val adapterlist = mutableListOf<Meme>()

    inner class ExampleViewHolder(private val binding: ExampleAdapterBinding):RecyclerView.ViewHolder(binding.root){
        fun onBind(item: Meme){
            binding.textView.text = item.name
            binding.textView2.text = item.url
            Glide
                .with(binding.root.context)
                .load(item.url)
                .into(binding.imageView);
        }
    }

    fun submitList(list: List<Meme>){
        adapterlist.clear()
        adapterlist.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): rcViewAdapter.ExampleViewHolder {
        return ExampleViewHolder(
            ExampleAdapterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun getItemCount(): Int {
        return  adapterlist.size
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        holder.onBind(adapterlist[position])
    }
}