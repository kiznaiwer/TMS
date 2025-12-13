package com.example.tms

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class FragmentMy: Fragment() {
    companion object {
        fun newInstance(index: Int): FragmentMy {
            val fragment = FragmentMy()
            val args = Bundle()
            args.putInt("index", index)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_my, container, false)

        val index = arguments?.getInt("index", 0) ?: 0
        val textView = view.findViewById<TextView>(R.id.fragment_text)
        textView.text = "Фрагмент №$index"

        return view
    }
}