package com.hixman.first_tabbar_andfragments.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.hixman.first_tabbar_andfragments.Fragments1
import java.text.FieldPosition

class PagerAdapter (supportFragmentManager: FragmentManager)
    :FragmentPagerAdapter(supportFragmentManager) {

    var list = ArrayList<String>()
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int):Fragment{
        return Fragments1.newInstance(list[position])
    }
}