package com.example.tms.tasks

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tms.R

class MaimActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maim)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, FragmentA())
                .commit()
        }
    }
}