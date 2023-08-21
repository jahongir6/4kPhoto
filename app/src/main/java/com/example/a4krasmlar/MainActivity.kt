package com.example.a4krasmlar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a4krasmlar.adapters.ViewPagerAdapter
import com.example.a4krasmlar.databinding.ActivityMainBinding
import com.example.a4krasmlar.db.MyImagesData
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity(), RvClick {
    private lateinit var binding: ActivityMainBinding
    private val titleList = arrayListOf("home", "popular", "random", "liked")
    var checkedNavItemIndex = 0
    private val imageMap = MyImagesData.loadMapList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var actionBarTitle = "Home"
        val tabTitles = arrayOf("ALL", "NEW", "ANIMALS", "TECHNOLOGY", "NATURE")

        binding.myViewPager.adapter =
            ViewPagerAdapter(this, imageMap[titleList[checkedNavItemIndex]], this)
        TabLayoutMediator(binding.myTabLayout, binding.myViewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()

        binding.imageMeny.setOnClickListener {
            binding.navDrawerLayout.open()
        }


        binding.myNavigation.setNavigationItemSelectedListener {
            if (it.itemId != R.id.menu_history && it.itemId != R.id.menu_about) {
                when (it.itemId) {
                    R.id.menu_home -> {
                        actionBarTitle = "Home"
                        checkedNavItemIndex = 0
                    }
                    R.id.menu_popular -> {
                        actionBarTitle = "Popular"
                        checkedNavItemIndex = 1
                    }
                    R.id.menu_random -> {
                        actionBarTitle = "Random"
                        checkedNavItemIndex = 2
                    }
                    R.id.menu_liked -> {
                        actionBarTitle = "My Favourites"
                        checkedNavItemIndex = 3
                    }
                }
                changeListImages(checkedNavItemIndex)
                binding.myBottomNavigation.menu.getItem(checkedNavItemIndex).isChecked = true
                binding.navDrawerLayout.close()
            } else {
                Toast.makeText(this, "NOT AVAILABLE", Toast.LENGTH_SHORT).show()
            }

            true
        }




        binding.myBottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    actionBarTitle = "Home"
                    checkedNavItemIndex = 0
                }
                R.id.dashboard -> {
                    actionBarTitle = "Popular"
                    checkedNavItemIndex = 1
                }
                R.id.notifications -> {
                    actionBarTitle = "Random"
                    checkedNavItemIndex = 2
                }
                R.id.profile -> {
                    actionBarTitle = "My Favourites"
                    checkedNavItemIndex = 3
                }
            }
            changeListImages(checkedNavItemIndex)
            true
        }

    }


    private fun changeListImages(position: Int) {
        binding.myViewPager.adapter =
            ViewPagerAdapter(this, imageMap[titleList[checkedNavItemIndex]], this)
    }

    override fun rvItemClicked(imageId: Int) {
        val intent = Intent(this, ShowMainActivity::class.java)
        intent.putExtra("id", imageId)
        startActivity(intent)
    }

}