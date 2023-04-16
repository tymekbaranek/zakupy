package com.example.zakupy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class MainActivity : AppCompatActivity() {
    private lateinit var PrzedmiotyKoszyk: Map<String, List<String>>
    private var WybraneArtykuły: MutableList<String> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        PrzedmiotyKoszyk = mapOf(
            "Warzywa" to listOf("Cebula", "Dynia", "Ziemniak","Boćwina"),
            "Mięso" to listOf("Wołowina", "Schab", "Parówka"),
            "Pieczywo" to listOf("Kajzerka", "Bochen", "Bułka")
        )


    }
}