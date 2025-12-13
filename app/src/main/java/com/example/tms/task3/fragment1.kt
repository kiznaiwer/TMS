package com.example.tms.task3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.tms.R
import com.example.tms.task2.FirstFragmentDirections

class fragment1: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.buttonToTwo).setOnClickListener {
            findNavController().navigate(R.id.action_fragment1_to_fragment2)
        }
        var resTextView = view.findViewById<TextView>(R.id.textView6)
        setFragmentResultListener("key1"){_, bundle ->
            val res = bundle.getString("key1", "Пусто")
            resTextView.text = res
        }
    }
}