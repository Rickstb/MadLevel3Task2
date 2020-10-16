package com.example.madlevel3task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_start.*

class StartFragment : Fragment() {

    private val listOfLocation = arrayListOf<Location>()
    private val StartAdapter = StartAdapter(listOfLocation)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       return inflater.inflate(R.layout.activity_start, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }
    private fun initView() {
        rvList.adapter = StartAdapter
        rvList.layoutManager = GridLayoutManager(context, 2)

        setFragmentResultListener(LOCATION_KEY) { key, bundle ->
            listOfLocation.add(bundle.getParcelable<Location>(KEY_LOCATION) as Location)
            StartAdapter.notifyDataSetChanged()
        }
    }
}