package com.rnnativemodule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainAppFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainAppFragment : Fragment(R.layout.fragment_main_app) {

    // In kotlin, object properties must be declared when declaring object so you can reference any object properties. But View object in Fragment is not inflated until onViewCreated is called so it need to defer the initialization of the object properties.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //after view is created, you can reference any view object
        val firstButton: Button = view.findViewById<Button>(R.id.next_screen_button)

        val secondButton: Button = view.findViewById<Button>(R.id.another_screen_button)

        firstButton.setOnClickListener {
            this.onButtonPress()
        }
        secondButton.setOnClickListener {
            this.onSecondButtonPress()
        }
    }

    private fun onButtonPress() {
        findNavController().navigate(R.id.firstFragment)
    }

    private fun onSecondButtonPress() {
        findNavController().navigate(R.id.secondFragment)
    }
}