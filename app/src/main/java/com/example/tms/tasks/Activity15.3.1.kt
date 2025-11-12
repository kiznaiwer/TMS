package com.example.tms.tasks

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tms.R

class Activity15: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1531)

        val message = intent.getStringExtra("key1")
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = message
    }
}