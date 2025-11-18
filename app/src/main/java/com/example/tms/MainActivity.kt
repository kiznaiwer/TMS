package com.example.tms

import Adapter
import android.content.Context
import android.os.Bundle
import android.widget.Button
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

    private val items = mutableListOf<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        addButton = findViewById(R.id.add_button)

        adapter = Adapter(items)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        addButton.setOnClickListener {
            val newItem = Item(
                title = "Заголовок ${items.size + 1}",
                description = "Описание элемента ${items.size + 1}"
            )
            adapter.addItem(newItem)
        }

        adapter.onActionClick = { item ->
            Toast.makeText(this, "Действие для: ${item.title}", Toast.LENGTH_SHORT).show()
        }
    }
}