package com.example.vinicius_panessa_rm94591

import Dica
import DicasAdapter
import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DicasAdapter
    private lateinit var searchView: SearchView
    private val dicasList = mutableListOf<Dica>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = DicasAdapter(dicasList, this)
        recyclerView.adapter = adapter

        carregarDicas()

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filter(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filter(newText)
                return true
            }
        })
    }

    private fun carregarDicas() {
        dicasList.add(Dica("Use lâmpadas LED", "Economize energia com lâmpadas mais eficientes."))
        dicasList.add(Dica("Desligue aparelhos", "Desconecte aparelhos quando não estiverem em uso."))
        adapter.notifyDataSetChanged()
    }

    private fun filter(query: String?) {
        val filteredList = dicasList.filter {
            it.title.contains(query ?: "", ignoreCase = true)
        }
        adapter = DicasAdapter(filteredList, this)
        recyclerView.adapter = adapter
    }
}