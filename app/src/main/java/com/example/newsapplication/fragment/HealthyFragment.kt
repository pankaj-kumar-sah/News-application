package com.example.newsapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.R
import com.example.newsapplication.adapter.HealthyAdapter
import com.example.newsapplication.data.HealthyData


class HealthyFragment : Fragment() {

    private lateinit var recyclerViewHealthy : RecyclerView
    private lateinit var healthyAdapter: HealthyAdapter
    private var healthyList = mutableListOf<HealthyData>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_healthy, container, false)


        recyclerViewHealthy = view.findViewById(R.id.recyclerViewHealty)
        recyclerViewHealthy.layoutManager = GridLayoutManager(context, 1)
        healthyAdapter = HealthyAdapter(context)




        recyclerViewHealthy.adapter = healthyAdapter

        healthyList.add(HealthyData(R.drawable.newsimage5))
        healthyList.add(HealthyData(R.drawable.newsimage2))
        healthyList.add(HealthyData(R.drawable.scenary))
        healthyList.add(HealthyData(R.drawable.newsimage1))
        healthyList.add(HealthyData(R.drawable.newsimage5))
        healthyList.add(HealthyData(R.drawable.newsimage2))
        healthyList.add(HealthyData(R.drawable.scenary))

        healthyAdapter.setHealthyList(healthyList)


        return view
    }


    }
