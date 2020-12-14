package com.hixman.first_tabbar_andfragments

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.hixman.first_tabbar_andfragments.Fragments.CategoryFragment
import com.hixman.first_tabbar_andfragments.Fragments.HomeFragment
import com.hixman.first_tabbar_andfragments.Fragments.MyListFragment
import com.hixman.first_tabbar_andfragments.Fragments.SettingsFragment
import com.ismaeldivita.chipnavigation.ChipNavigationBar


class MainActivity : AppCompatActivity() {


    private lateinit var navBar:ChipNavigationBar
    private  var fragment:Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(HomeFragment())
        navBar= findViewById(R.id.navBar)

        navBar.setOnItemSelectedListener { id ->

            fragment = null
            when(id){

                R.id.home ->{
                    fragment = HomeFragment()
                }
                R.id.myList ->{
                    fragment = MyListFragment()
                }
                R.id.category ->{
                    fragment = CategoryFragment()
                }
                R.id.settings ->{
                    fragment = SettingsFragment()
                }
            }
            loadFragment(fragment!!)
        }

    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container,fragment)
            .commit()

    }


    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setTitle("Exit")
            .setMessage("Are you sure want to exit ?")
            .setNegativeButton("Cancel") { dialog, _ -> dialog.dismiss() }
            .setPositiveButton("Yes") { _, _ -> super.onBackPressed() }
            .show()
    }
}