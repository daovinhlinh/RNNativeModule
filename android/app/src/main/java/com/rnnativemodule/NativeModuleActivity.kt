package com.rnnativemodule

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupActionBarWithNavController

class NativeModuleActivity: AppCompatActivity() {
    lateinit var nav: NavController
    override fun onSupportNavigateUp(): Boolean = nav.navigateUp()

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.view_layout)
        setSupportActionBar(findViewById(R.id.toolbar))

        nav = Navigation.findNavController(this, R.id.fragment_nav)

        setupActionBarWithNavController(nav)
        val screenId =  intent.getStringExtra("screenId")
        Log.d("screenId", screenId ?: "")
        when (intent.getStringExtra("screenId")) {
            "first" -> nav.navigate(R.id.firstFragment)
            "second" -> nav.navigate(R.id.secondFragment)
        }
    }
}