package com.example.tms

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.TextView
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
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter
    private lateinit var addButton: Button
    private lateinit var emptyTextView: TextView

    private val items = mutableListOf<Item>()
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var adapter: FragmentAdpater
    private lateinit var addButton: Button
    private lateinit var counterTextView: TextView

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
        recyclerView = findViewById(R.id.recycler_view)
        addButton = findViewById(R.id.add_button)
        emptyTextView = findViewById(R.id.empty_text_view)


    private fun updateTextViewAuto(){
        lifecycleScope.launch {
            for (i in 1..10){
                delay(1000)
                binding.text.text = "$i"
            }
        updateEmptyView()

        addButton.setOnClickListener {
            val newItem = Item(
                title = "Заголовок ${items.size + 1}",
                description = "Описание элемента ${items.size + 1}"
            )
            adapter.addItem(newItem)
            updateEmptyView()
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

    private fun updateEmptyView() {
        if (adapter.itemCount == 0) {
            emptyTextView.visibility = View.VISIBLE
            recyclerView.visibility = View.GONE
        } else {
            emptyTextView.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
        viewPager = findViewById(R.id.view_pager)
        addButton = findViewById(R.id.add_fragment_button)
        counterTextView = findViewById(R.id.counter_text_view)

        adapter = FragmentAdpater(this)
        viewPager.adapter = adapter

        // Обновляем счётчик при старте
        updateCounter()

        addButton.setOnClickListener {
            if (adapter.getItemCount() < 5) { // Ограничиваем до 5 фрагментов
                adapter.addFragment()
                updateCounter()
            } else {
                addButton.text = "Максимум!"
                addButton.isEnabled = false
            }
        }

        val button = findViewById<Button>(R.id.buttonTask)
        button.setOnClickListener {
            val intent = Intent(this, IntentActivity::class.java)
            intent.putExtra("key1", "Hello, Second Activity")
            startActivity(intent)
        }

        val button2 = findViewById<Button>(R.id.buttonTask2)
        button2.setOnClickListener {
            val  intent = Intent(this, MaimActivity::class.java)
            startActivity(intent)
        }

        val button3 = findViewById<Button>(R.id.buttonTassk3)
        button3.setOnClickListener {
            val intent = Intent(this, MaikActivity::class.java)
            startActivity(intent)
        }

        val button4 = findViewById<Button>(R.id.buttonTask4)
        button4.setOnClickListener {
            val intent = Intent(this, MaisActivity::class.java)
            startActivity(intent)
        }

        val button5 = findViewById<Button>(R.id.buttonTask5)
        button5.setOnClickListener {
            val intent = Intent(this, MaicActivity::class.java)
            startActivity(intent)
        }

        fun addFragment(fragment: Fragment) {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()

            fragmentTransaction.replace(R.id.fragment_container, fragment)

            fragmentTransaction.commit()
        }
    }

    private fun updateCounter() {
        val count = adapter.getItemCount()
        counterTextView.text = "Фрагментов: $count / 5"
    }
}