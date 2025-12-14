package com.example.tms.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.tms.databinding.FragmentListBinding
import kotlin.getValue

class ListFragment: Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private val args: ListFragmentArgs by navArgs()  //принятие обьекта


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textV.text = args.message.text
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}