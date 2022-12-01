package com.example.lugar_semanal2.ui.lugar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

import com.example.lugar_semanal2.databinding.FragmentLugarBinding
import com.example.lugar_semanal2.viewmodel.LugarViewModel

class LugarFragment : Fragment() {

    private var _binding: FragmentLugarBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View {

        val lugarViewModel =
            ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            )[LugarViewModel::class.java]

        _binding = FragmentLugarBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textLugar
        return root
        }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}