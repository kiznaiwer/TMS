package com.example.tms

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tms.R
import com.example.tms.databinding.ActivityMainBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.jvm.Throws

class MainActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        updateTextViewAuto()

        binding.btnClck.setOnClickListener {
            updateTextViewButton()
        }
    }


    private fun updateTextViewAuto(){
        lifecycleScope.launch {
            for (i in 1..10){
                delay(1000)
                binding.text.text = "$i"
            }
        }
    }

    private fun updateTextViewButton(){
        lifecycleScope.launch {
            for (i in 10 downTo 1){
                delay(1000)
                binding.textView.text = "$i"
            }
        }
    }

}