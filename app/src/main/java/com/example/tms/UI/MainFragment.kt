package com.example.tms.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tms.Data.UserMessage
import com.example.tms.databinding.FragmentMainBinding

class MainFragment: Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            val text = binding.inputText.editText   // проверка на мусор
                ?.text
                ?.toString()
                ?.trim()
                ?.takeIf { it.isNotEmpty() }
                ?: return@setOnClickListener   // флаг для выхода из лямбды, а не из функции
            val message = UserMessage(
                text = binding.Hint.text.toString(),
                timeStamp = System.currentTimeMillis()
            )

            val action = MainFragmentDirections.actionMainFragmentToListFragment(message)

            findNavController().navigate(action)
        }
    }



    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}