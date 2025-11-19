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
        }
    }
}