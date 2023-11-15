package com.rnnativemodule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import com.facebook.react.bridge.ReactMethod
import com.rnnativemodule.databinding.FragmentFirstBinding
import androidx.recyclerview.widget.RecyclerView
import com.rnnativemodule.gallery.RecyclerAdapter


class FirstFragment : Fragment(R.layout.fragment_first) {
//    private lateinit var binding: FragmentFirstBinding
    var recyclerView: RecyclerView? = null
    var Manager: GridLayoutManager? = null
    var adapter: RecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }



    fun testPerf() {
        val startTime = System.currentTimeMillis()
        repeat(1000000) {
            listOf(1, 2, 3, 4, 5).sum()
        }
        val endTime = System.currentTimeMillis()
        println("Time taken: ${endTime - startTime} ms")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

       val rootView = inflater.inflate(R.layout.fragment_first, container, false)
//        val view = binding.root
//        setContentView(view)


        recyclerView = rootView.findViewById<View>(R.id.rv_design) as RecyclerView
        Manager = GridLayoutManager(requireContext(),2)
        recyclerView!!.layoutManager = Manager
        adapter = RecyclerAdapter(requireContext())
        recyclerView!!.adapter = adapter

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//
//        val testButton: Button = view.findViewById<Button>(R.id.test_button)
//
//        testButton.setOnClickListener {
//            this.testPerf()
//        }
    }
}
