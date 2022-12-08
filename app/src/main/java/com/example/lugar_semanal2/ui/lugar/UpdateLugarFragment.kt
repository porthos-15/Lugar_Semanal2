package com.example.lugar_semanal2.ui.lugar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.lugar_semanal2.R
import com.example.lugar_semanal2.databinding.FragmentUpdateLugarBinding
import com.example.lugar_semanal2.databinding.FragmentLugarBinding
import com.example.lugar_semanal2.model.Lugar
import com.example.lugar_semanal2.viewmodel.LugarViewModel


class UpdateLugarFragment : Fragment() {
    private var _binding: FragmentUpdateLugarBinding? = null
    private val binding get() = _binding!!
    private lateinit var lugarViewModel: LugarViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        lugarViewModel =  ViewModelProvider(this ).get(LugarViewModel::class.java)
        _binding = FragmentUpdateLugarBinding.inflate(inflater, container, false)


binding.btUpdateugar.setOnClickListener{UpdateLugar()}


        return binding.root
    }
    //efectivamente hace el registro del lugar en la base de datos

    private fun UpdateLugar() {
            val nombre = binding.etNombre.text.toString()
        val correo=binding.etCorreoLugar.text.toString()
        val telefono = binding.etTelefono.text.toString()

        val web = binding.etWeb.text.toString()
        if (nombre.isNotEmpty()){ //almenos tenemos un nombre
            val lugar = Lugar(0,nombre,correo,telefono,web,0.0,0.0)
lugarViewModel.saveLugar(lugar)
            Toast.makeText(requireContext(),getString(R.string.msg_lugar_added),Toast.LENGTH_SHORT).show()
        }else {
            Toast.makeText(requireContext(),getString(R.string.msg_data),Toast.LENGTH_LONG).show()


        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}