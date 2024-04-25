package com.example.iusademoapp.views.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.iusademoapp.databinding.FragmentSecondBinding
import com.example.iusademoapp.model.adapter.MotosFindAdapter
import com.example.iusademoapp.model.response.MotoResponse
import com.google.gson.Gson

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    private val binding get() = _binding!!

    private lateinit var findMotos: MotoResponse

    private lateinit var adapter: MotosFindAdapter

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val gson = Gson()

        findMotos = gson.fromJson(getArguments()?.getString("findMotos").toString(), MotoResponse::class.java)

        println("> From JSON String:\n$findMotos")
        initRecyclerView()

    }

    private fun initRecyclerView() {
        adapter = MotosFindAdapter(findMotos.motos)
        binding.rvMoto.layoutManager = LinearLayoutManager(context)
        binding.rvMoto.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}