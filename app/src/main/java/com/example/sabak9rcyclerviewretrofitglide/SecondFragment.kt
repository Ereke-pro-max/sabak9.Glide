package com.example.sabak9rcyclerviewretrofitglide

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.sabak9rcyclerviewretrofitglide.data.RetrofitService
import com.example.sabak9rcyclerviewretrofitglide.databinding.FragmentSecondBinding
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSecondFragment.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
        }

        lifecycleScope.launch {
            try {
                val data = RetrofitService.apiServiceAmiibo.getAmiibo()
                val listAmibo = data.amiibo
                val adapterAmiibo = AmiiboAdapter()
                binding.rcSecondFragment.adapter = adapterAmiibo
                adapterAmiibo.submitAmiiboList(listAmibo)
            }catch (e:Exception){
                Log.d("AAA", e.message.toString())
            }
        }
    }
}