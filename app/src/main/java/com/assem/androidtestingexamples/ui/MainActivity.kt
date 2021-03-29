package com.assem.androidtestingexamples.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.assem.androidtestingexamples.R
import com.assem.androidtestingexamples.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    public lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var fragmentFactory: ShoppingFragmentFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        supportFragmentManager.fragmentFactory = fragmentFactory
        setContentView(view)
    }
}