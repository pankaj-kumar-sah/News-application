package com.example.newsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.viewpager.widget.ViewPager
import com.example.newsapplication.adapter.TabPagerAdapter
import com.example.newsapplication.fragment.*
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.tabs.TabLayout

class SecondActivity : AppCompatActivity() {

    private lateinit var secondPageTabViewPager : ViewPager
    private lateinit var secondPageTabs : TabLayout


    //creating button for bottom dialog
    lateinit var btnShowBottomSheet: ImageView
    lateinit var btnClose : FrameLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

            secondPageTabViewPager = findViewById(R.id.secondPageTabViewPager)
            secondPageTabs = findViewById(R.id.secondPageTabs)

            // adding on click listener to selected filter tab

            // TabLayout.Tab tab = secondPageTabs.getTabAt(0)
            // val filterTab = secondPageTabs.getTabAt(0)?.select()
            // filterTab.
        setUpTabs1()


        secondPageTabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    tab.position
                    if(tab.position==0)
                    {
                        val view1 = layoutInflater.inflate(R.layout.bottom_sheet_dialog, null)

                        val dialog = BottomSheetDialog(this@SecondActivity)
                        val btnClose = view1.findViewById<Button>(R.id.idBtnDismiss)
                        btnClose.setOnClickListener{
                            dialog.dismiss()
                        }
                        dialog.setCancelable(false)
                        dialog.setContentView(view1)
                        dialog.show()                }
                    //do stuff here
                }

                override fun onTabUnselected(tab: TabLayout.Tab) {}
                override fun onTabReselected(tab: TabLayout.Tab) {}
            })


        }

         fun setUpTabs1() {
            val adapter = TabPagerAdapter(supportFragmentManager)
            adapter.addFragment(HealthyFragment(),"")
            adapter.addFragment(HealthyFragment(),"")
            adapter.addFragment(HealthyFragment(),"")
            adapter.addFragment(HealthyFragment(),"")
            adapter.addFragment(HealthyFragment(),"")

            secondPageTabViewPager.adapter = adapter
            secondPageTabs.setupWithViewPager(secondPageTabViewPager)

            secondPageTabs.getTabAt(0)!!.text = "Filter"
            secondPageTabs.getTabAt(1)!!.text = "Healthy"
            secondPageTabs.getTabAt(2)!!.text = "Technology"
            secondPageTabs.getTabAt(3)!!.text = "Arts"
            secondPageTabs.getTabAt(4)!!.text = "Science"

            //  secondPageTabViewPager.setCurrentItem(0)
        }

    }
