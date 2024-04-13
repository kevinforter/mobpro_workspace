package ch.hslu.informatik.mobpro.intent_and_widget

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ch.hslu.informatik.mobpro.intent_and_widget.R

class MyMapActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_map)

        val textView = findViewById<TextView>(R.id.textViewCoordinates)
        textView.text = "Location: ${intent.data}"
    }
}
