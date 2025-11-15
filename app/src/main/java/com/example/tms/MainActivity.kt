package com.example.tms

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.tms.tasks.MaimActivity
import com.example.tms.tasks.IntentActivity
import kotlin.jvm.java
import com.example.tms.task1.MaikActivity
import com.example.tms.task2.MaisActivity
import com.example.tms.task3.MaicActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
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
}