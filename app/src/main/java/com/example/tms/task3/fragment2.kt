package com.example.tms.task3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.tms.R

class fragment2: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val resToOne = view.findViewById<Button>(R.id.buttonStrToOne)
        resToOne.setOnClickListener {
            val resBundle = Bundle().apply {
                putString("key1", "Результат")
            }
            setFragmentResult("key1", resBundle)

            findNavController().popBackStack()
        }
    }
}