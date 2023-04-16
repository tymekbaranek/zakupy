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

        fun Usuwanie() {
            val checkboxesLayout = findViewById<View>(R.id.checkboxesLayout)
            val chipsLayout = findViewById<View>(R.id.chipsLayout)

            checkboxesLayout.visibility = View.GONE
            chipsLayout.visibility = View.VISIBLE

            val GrupaChip = findViewById<ChipGroup>(R.id.chipsGroup)
            GrupaChip.removeAllViews()

            for ((groupName, items) in PrzedmiotyKoszyk) {
                for (item in items) {
                    if (WybraneArtykuły.contains(item)) {
                        val chip = Chip(this)
                        chip.text = item
                        chip.isCloseIconVisible = true
                        chip.tag = groupName

                        when (groupName) {
                            "Warzywa" -> {
                                chip.chipBackgroundColor =
                                    resources.getColorStateList(R.color.Warzywa)
                            }
                            "Mięso" -> {
                                chip.chipBackgroundColor =
                                    resources.getColorStateList(R.color.Mieso)
                            }
                            "Pieczywo" -> {
                                chip.chipBackgroundColor =
                                    resources.getColorStateList(R.color.Pieczywo)
                            }
                        }
                        GrupaChip.addView(chip)

                        chip.setOnCloseIconClickListener {
                            WybraneArtykuły.remove(item)
                            GrupaChip.removeView(chip)
                        }
                    }
                }
            }
        }

        fun Dodawanie() {
            val LayoutCheckbox = findViewById<View>(R.id.checkboxesLayout)
            val LayoutChip = findViewById<View>(R.id.chipsLayout)

            LayoutCheckbox.visibility = View.VISIBLE
            LayoutChip.visibility = View.GONE
        }

        val GrupaRadio = findViewById<RadioGroup>(R.id.radioGroup)

        GrupaRadio.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.Dodawanie -> Dodawanie()
                R.id.Usuwanie -> Usuwanie()
            }
        }


    }
}