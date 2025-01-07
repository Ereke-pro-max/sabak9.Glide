package com.example.sabak9rcyclerviewretrofitglide

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.sabak9rcyclerviewretrofitglide.data.Meme
import com.example.sabak9rcyclerviewretrofitglide.data.MemesResponce
import com.example.sabak9rcyclerviewretrofitglide.data.RetrofitService
import com.example.sabak9rcyclerviewretrofitglide.databinding.ActivityMainBinding
import com.example.sabak9rcyclerviewretrofitglide.databinding.FragmentFirstBinding
import kotlinx.coroutines.launch
import okhttp3.Response

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnChangeFragmentForFirst.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

        lifecycleScope.launch {
            try {
                val response = RetrofitService.apiService.getMeme()
                val listMemes: List<Meme> = response.data.memes
                val adapter = rcViewAdapter()
                binding.RcFirstFragment.adapter = adapter
                adapter.submitList(listMemes)
            } catch (e:Exception){
                Log.d("AAA", e.message.toString())
            }

        }
    }
}