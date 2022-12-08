package com.example.lugar_semanal2.ui.lugar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lugar_semanal2.R
import com.example.lugar_semanal2.adapter.LugarAdapter

import com.example.lugar_semanal2.databinding.FragmentLugarBinding
import com.example.lugar_semanal2.viewmodel.LugarViewModel

class LugarFragment : Fragment() {

    private var _binding: FragmentLugarBinding? = null
    private val binding get() = _binding!!
private lateinit var lugarViewModel: LugarViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        lugarViewModel =  ViewModelProvider(this ).get(LugarViewModel::class.java)
        _binding = FragmentLugarBinding.inflate(inflater, container, false)
         binding.addLugarFatBt.setOnClickListener{
             findNavController().navigate(R.id.action_nav_lugar_to_addLugarFragment)
         }
//Activar el Recycler View con la vista de lugares usando el  Adapter..
        val lugarAdapter=LugarAdapter()
        val reciclador = binding.reciclador
        reciclador.adapter = lugarAdapter
        reciclador.layoutManager = LinearLayoutManager(requireContext())

          lugarViewModel.getLugares.observe(viewLifecycleOwner){
              lugares -> lugarAdapter.setLugares(lugares)
          }
        return binding.root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}