package com.example.newsapplication
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.newsapplication.adapter.TabPagerAdapter
import com.example.newsapplication.adapter.ViewPagerAdapter
import com.example.newsapplication.fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    lateinit var viewPager: ViewPager
    lateinit var viewPagerAdapter: ViewPagerAdapter
    lateinit var viewPagerimageList: List<Int>

    private lateinit var tabviewPager : ViewPager
    private lateinit var tabs : TabLayout
   private lateinit var forwardArrow : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.tollbar))

        forwardArrow = findViewById(R.id.forwardArrow)
        // initializing variables
        // of below line with their id.
        viewPager = findViewById(R.id.viewPagerID)

        // initializing the tab viewpager
        tabviewPager = findViewById(R.id.tabviewPager)
        tabs = findViewById<TabLayout>(R.id.tabs)

        // on below line we are initializing
        // our image list and adding data to it.
        viewPagerimageList = ArrayList<Int>()
        viewPagerimageList = viewPagerimageList + R.drawable.newsimage1
        viewPagerimageList = viewPagerimageList + R.drawable.newsimage2
        viewPagerimageList = viewPagerimageList + R.drawable.newsimage1
        viewPagerimageList = viewPagerimageList + R.drawable.newsimage4
        viewPagerimageList = viewPagerimageList + R.drawable.newsimage5

        // on below line we are initializing our view
        // pager adapter and adding image list to it.
        viewPagerAdapter = ViewPagerAdapter(this@MainActivity, viewPagerimageList)

        // on below line we are setting
        // adapter to our view pager.
        viewPager.adapter = viewPagerAdapter


       // onclick listener and navigation function
//        forwardArrow.setOnClickListener{
//            val navfragment = SecondPageFragment()
//            val transaction = fragmentManager?.beginTransaction()
//            transaction?.replace(R.id.container,navfragment)?.hashCode()
//        }
        //navigating to thirdpage activity through intent
        forwardArrow.setOnClickListener{

            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
//       val secondPageFragment = SecondPageFragment()
//            val fragment : Fragment
//
//            supportFragmentManager.findFragmentByTag(SecondPageFragment::class.java.simpleName)



        }
        for (i in 0 until tabs.tabCount) {
            val tab = (tabs.getChildAt(0) as ViewGroup).getChildAt(i)
            val p = tab.layoutParams as ViewGroup.MarginLayoutParams
            p.setMargins(50, 0, 50, 0)
            tab.requestLayout()
        }


        setUpTabs()
        //setUpBottomNavBar()
    }

    private fun setUpTabs() {
        val adapter = TabPagerAdapter(supportFragmentManager)
        adapter.addFragment(HealthyFragment(),"")
        adapter.addFragment(HealthyFragment(),"")
        adapter.addFragment(HealthyFragment(),"")
        adapter.addFragment(HealthyFragment(),"")
        adapter.addFragment(HealthyFragment(),"")

        tabviewPager.adapter = adapter
        tabs.setupWithViewPager(tabviewPager)

        tabs.getTabAt(0)!!.text = "Healthy"
       tabs.getTabAt(1)!!.text = "Technology"
        tabs.getTabAt(2)!!.text = "Finance"
       tabs.getTabAt(3)!!.text = "Arts"
        tabs.getTabAt(4)!!.text = "Sports"

    }

  /*  private fun setUpBottomNavBar()
    {
        loadFragment(HealthyFragment())
        var bottomNav = findViewById(R.id.bottomNav) as BottomNavigationView
        bottomNav.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.bottomNavHome -> {
                    loadFragment(HealthyFragment())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.bottomNavFavourite -> {
                    loadFragment(HealthyFragment())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.bottomNavProfile -> {
                    loadFragment(HealthyFragment())
                    return@setOnNavigationItemReselectedListener
                }
            }
        }

    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
*/
    //function to navigate from this activity to second fragment

    //getSupportFragmentManager().beginTransaction().replace(R.id.container,new DashBoardFragment()).commit();


}