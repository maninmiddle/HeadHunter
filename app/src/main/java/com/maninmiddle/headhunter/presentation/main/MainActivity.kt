package com.maninmiddle.headhunter.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.feature_favourite.presentation.FavouriteFragment
import com.maninmiddle.core.util.MainActivityFragmentContract
import com.maninmiddle.feature_search.presentation.search.SearchFragment
import com.maninmiddle.headhunter.R
import com.maninmiddle.headhunter.databinding.ActivityMainBinding
import com.maninmiddle.headhunter.presentation.fragments.plug.PlugFragment

class MainActivity : AppCompatActivity(), MainActivityFragmentContract {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(SearchFragment())

        binding.bottomNav.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menuSearch -> {
                    replaceFragment(SearchFragment())
                    true
                }

                R.id.menuFav -> {
                    replaceFragment(FavouriteFragment())
                    true
                }

                R.id.menuProfile -> {
                    replaceFragment(PlugFragment())
                    true
                }

                R.id.menuMessages -> {
                    replaceFragment(PlugFragment())
                    true
                }

                R.id.menuResponses -> {
                    replaceFragment(PlugFragment())
                    true
                }

                else -> false
            }
        }
    }

    override fun addFragment(fragment: Fragment, addToBackStack: Boolean) {
        val supportFragmentManager = supportFragmentManager.beginTransaction()
        supportFragmentManager.add(binding.frameLayout.id, fragment)

        if (addToBackStack)
            supportFragmentManager.addToBackStack(null)

        supportFragmentManager.commit()
    }

    override fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(binding.frameLayout.id, fragment).commit()
    }

    override fun setNotificationCount(count: Int) {
        binding.bottomNav.getOrCreateBadge(R.id.menuFav).number = count
    }
}