package com.example.tms

import Adapter
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tms.Item
import com.example.tms.R

class MainActivity : AppCompatActivity() {

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        addButton = findViewById(R.id.add_button)
        emptyTextView = findViewById(R.id.empty_text_view)

        adapter = Adapter(items)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        updateEmptyView()

        addButton.setOnClickListener {
            val newItem = Item(
                title = "Заголовок ${items.size + 1}",
                description = "Описание элемента ${items.size + 1}"
            )
            adapter.addItem(newItem)
            updateEmptyView()
        }

        adapter.onActionClick = { item ->
            Toast.makeText(this, "Действие для: ${item.title}", Toast.LENGTH_SHORT).show()
        }
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