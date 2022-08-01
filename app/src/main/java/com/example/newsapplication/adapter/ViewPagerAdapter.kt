package com.example.newsapplication.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.viewpager.widget.PagerAdapter
import com.example.newsapplication.R
import com.example.newsapplication.ThirdPageActivity
import java.util.*

class ViewPagerAdapter(val context: Context, val viewPagerimageList: List<Int>) : PagerAdapter() {
    // on below line we are creating a method
    // as get count to return the size of the list.




    override fun getCount(): Int {
        return viewPagerimageList.size
    }

    // on below line we are returning the object
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as CardView
    }

    // on below line we are initializing
    // our item and inflating our layout file
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        // on below line we are initializing
        // our layout inflater.
        val mLayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        // on below line we are inflating our custom
        // layout file which we have created.
        val itemView: View = mLayoutInflater.inflate(R.layout.imageviewer, container, false)

        // on below line we are initializing
        // our image view with the id.
        val imageView: ImageView = itemView.findViewById<View>(R.id.imageViewer_image) as ImageView
        val imageViewer_text = itemView.findViewById<CardView>(R.id.imageViewer_tapbtn)

        imageViewer_text.setOnClickListener{
            val intent = Intent(context, ThirdPageActivity::class.java)
            context.startActivity(intent)
        }


        // on below line we are setting
        // image resource for image view.
        imageView.setImageResource(viewPagerimageList.get(position))

        // on the below line we are adding this
        // item view to the container.
        Objects.requireNonNull(container).addView(itemView)

        // on below line we are simply
        // returning our item view.
        return itemView
    }

    // on below line we are creating a destroy item method.
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        // on below line we are removing view
        container.removeView(`object` as CardView)
    }

}
