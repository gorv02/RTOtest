package com.example.rtotest.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rtotest.R
import com.example.rtotest.adapter.TrafficSignsAdapter
import com.example.rtotest.dataGenerator.listTrafficIcons
import com.example.rtotest.model.TrafficSigns

class TrafficSigns : Fragment() {

    private lateinit var rvTrafficSigns: RecyclerView
    private lateinit var trafficSignList: List<TrafficSigns>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_traffic_signs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showRvTrafficSigns(view)
    }

    private fun showRvTrafficSigns(view: View) {
        trafficSignList = listTrafficIcons(40)

        rvTrafficSigns = view.findViewById(R.id.rv_traffic_sign)
        val gridLM = GridLayoutManager(
            activity,
            3,
            LinearLayoutManager.VERTICAL,
            false
        )
        rvTrafficSigns.apply {
            layoutManager = gridLM
            adapter = TrafficSignsAdapter(trafficSignList)
        }
    }
}