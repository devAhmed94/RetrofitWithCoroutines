package com.example.retrofitwithcoroutines.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitwithcoroutines.adapter.MainAdapter
import com.example.retrofitwithcoroutines.databinding.ActivityMainBinding
import com.example.retrofitwithcoroutines.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val mainViewModel by viewModels<MainViewModel>()
    val myAdapter by lazy { MainAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecycler()
        receiveResponse()


    }

    private fun receiveResponse() {
        mainViewModel.getMutableList()?.observe(this, {
            myAdapter.setList(it)
            Log.d("MOMO", "receiveResponse: ${it[0].title}")
        })
    }

    private fun initRecycler() {
        with(binding) {
            rvMain.apply {
                layoutManager =
                    LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                setHasFixedSize(true)
                adapter = myAdapter

            }
        }
    }
}