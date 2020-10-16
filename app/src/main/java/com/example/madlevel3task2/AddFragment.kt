package com.example.madlevel3task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_add.*

const val KEY_LOCATION = "location"
const val LOCATION_KEY = "locationkey"

class AddFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_add, container, false)
    }
    private fun initView() {
        btnAddPortal.setOnClickListener {
            val portal = Location(edTitle.text.toString(), edUrl.text.toString())
            if (portal.title.isNotBlank() && portal.url.isNotBlank()) {
                val bundle = Bundle()
                bundle.putParcelable(KEY_LOCATION, portal)
                setFragmentResult(LOCATION_KEY, bundle)
                findNavController().popBackStack()
            } else {
                Toast.makeText(context, "Not all field were fillt in", Toast.LENGTH_LONG).show()
            }
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }
}