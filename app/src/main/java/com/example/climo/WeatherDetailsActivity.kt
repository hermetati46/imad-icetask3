package com.example.climo

import android.os.Bundle
import android.widget.Button
import android.graphics.Color
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat

class WeatherDetailsActivity : AppCompatActivity() {

    // Sample Hardcoded Data
    private val days = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    private val maxTemps = arrayOf(25, 29, 22, 24, 20, 18, 16)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_details)

        val weatherDataContainer: LinearLayout = findViewById(R.id.weatherDataContainer)
        val averageTempTextView: TextView = findViewById(R.id.averageTempTextView)
        val backButton: Button = findViewById(R.id.backButton)

        // Display each day with its max temperature
        for (i in days.indices) {
            val dayTextView = TextView(this)
            dayTextView.text = "${days[i]}: ${maxTemps[i]}°C"
            dayTextView.textSize = 26f
            dayTextView.setTextColor(Color.WHITE)
            dayTextView.setPadding(8, 8, 8, 8)
            weatherDataContainer.addView(dayTextView)
        }

        // Calculate and show the average max temperature
        var sumOfTemps = 0
        for (temp in maxTemps) {
            sumOfTemps += temp
        }

        val averageTemp = if (maxTemps.isNotEmpty()) {
            sumOfTemps.toDouble() / maxTemps.size
        } else {
            0.0
        }

        val decimalFormat = DecimalFormat("#.##") // Format to two decimal places
        averageTempTextView.text = "Average Max Temperature: ${decimalFormat.format(averageTemp)}°C"

        // Handle Back button click
        backButton.setOnClickListener {
            // Navigate back to MainActivity (Welcome Screen)
            // Finish current activity
            finish()
        }
    }
}