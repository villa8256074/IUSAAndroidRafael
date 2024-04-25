package com.example.iusademoapp.views.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.iusademoapp.R
import com.example.iusademoapp.databinding.FragmentFirstBinding
import com.example.iusademoapp.model.request.userDataRequest
import com.example.iusademoapp.services.APIService
import com.example.iusademoapp.services.CallRetrofit
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findMotosAPI(binding.editTextText.text.toString(), binding.editTextPhone.text.toString(), binding.editTextTextEmailAddress.text.toString())

        }
    }

    private fun findMotosAPI (name: String, phone: String, mail: String) {
        var usrDataRequest: userDataRequest = userDataRequest(fullName = name, phone = phone, mail = mail)
        print(usrDataRequest)
        CoroutineScope(Dispatchers.Main).launch {
            val call = CallRetrofit().getRetrofit().create(APIService::class.java).postFindUser(requestBody = usrDataRequest)
            val motos = call.body()
            Log.i("App", motos.toString())
            if(call.isSuccessful){
                print(motos)
                val bundle = Bundle()
                val gson = Gson()

                val jsonConvert: String = gson.toJson(motos)
                println(jsonConvert)
                bundle.putString("findMotos", jsonConvert)
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}