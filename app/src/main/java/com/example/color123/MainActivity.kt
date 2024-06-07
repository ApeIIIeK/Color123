package com.example.color123
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.color123.R

class MainActivity : AppCompatActivity() {

    private lateinit var colorText: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        colorText = findViewById(R.id.colorText)
        button = findViewById(R.id.button)

        button.setOnClickListener {
            showColorPickerDialog()
        }
    }

    private fun showColorPickerDialog() {
        val builder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.color_dialog, null)

        val redSeekBar = view.findViewById<SeekBar>(R.id.redSeekBar)
        val greenSeekBar = view.findViewById<SeekBar>(R.id.greenSeekBar)
        val blueSeekBar = view.findViewById<SeekBar>(R.id.blueSeekBar)

        builder.setView(view)
            .setTitle("Choose color")
            .setPositiveButton("OK") { _, _ ->
                val redValue = redSeekBar.progress
                val greenValue = greenSeekBar.progress
                val blueValue = blueSeekBar.progress

                val color = Color.rgb(redValue, greenValue, blueValue)
                colorText.setBackgroundColor(color)
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}