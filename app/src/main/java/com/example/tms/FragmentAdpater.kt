package com.example.tms

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdpater(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    private val fragments = mutableListOf<FragmentMy>()

    fun addFragment() {
        val newIndex = fragments.size + 1
        val fragment = FragmentMy.newInstance(newIndex)
        fragments.add(fragment)
        notifyItemInserted(fragments.size - 1)
    }

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}