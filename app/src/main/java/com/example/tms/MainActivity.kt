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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.jvm.Throws

class MainActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var buttonUpdateJob: Job? = null

    private var live = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        updateTextViewAuto()

        binding.btnClck.setOnClickListener {
            lookLive()
        }
//        binding.openSumm.setOnClickListener {
//            number1000()
//        }
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
        live = true
        binding.btnClck.text = "Stop"
        buttonUpdateJob = lifecycleScope.launch {
            for (i in 10 downTo 1){
                delay(1000)
                binding.textView.text = "$i"
            }
            withContext(Dispatchers.Main) {
                live = false
                binding.btnClck.text = "Click"
                binding.textView.text = "Готово"
            }
        }
    }

    private fun stopUpdateTextViewButton(){
        live = false
        buttonUpdateJob?.cancel()
        buttonUpdateJob = null
        binding.textView.text = "отменено"
        binding.btnClck.text = "Click"
    }

    private fun lookLive(){
        if (live) stopUpdateTextViewButton()
        else updateTextViewButton()
    }

//    private fun number1000(){
//        binding.summ.text = "Вычисляем сумму"
//        val result = lifecycleScope.async(Dispatchers.Default) {
//            delay(3000)
//            var sum = 0
//            for (i in 1..1000){
//                sum += (1..10).random()
//            }
//            binding.summ.text = sum.toString()
//        }
//    }

    override fun onDestroy() {
        super.onDestroy()
        buttonUpdateJob?.cancel()
    }

}