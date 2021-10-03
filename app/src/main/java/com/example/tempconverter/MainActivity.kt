package com.example.tempconverter

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tempconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnConvert.setOnClickListener { convertTemp() }
        binding.btnReset.setOnClickListener { reset() }
    }

    private fun reset() {
        binding.etCelcius.text = null
        binding.etFahrenheit.text = null
    }

    private fun convertTemp() {
        val celsius = binding.etCelcius.text.toString().toDoubleOrNull()
        val fahrenheit = binding.etFahrenheit.text.toString().toDoubleOrNull()

        if (celsius == null && fahrenheit == null) {
            return
        } else if (celsius != null && fahrenheit == null) {
            binding.etFahrenheit.setText(((celsius * 1.8) + 32).toString())
        } else if (celsius == null && fahrenheit != null) {
            binding.etCelcius.setText(((fahrenheit - 32) * 0.5556).toString())
        } else {
            Toast.makeText(this, "Failed conversion.", Toast.LENGTH_SHORT)
        }
    }
}