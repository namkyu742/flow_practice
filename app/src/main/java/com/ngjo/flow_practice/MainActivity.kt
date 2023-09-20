package com.ngjo.flow_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ngjo.flow_practice.ui_layer.uielement.TestFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val testFragment = TestFragment.newInstance()

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, testFragment)
            .commit()
    }
}