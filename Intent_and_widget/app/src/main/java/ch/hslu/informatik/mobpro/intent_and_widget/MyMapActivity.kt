package ch.hslu.informatik.mobpro.intent_and_widget

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ch.hslu.informatik.mobpro.intent_and_widget.R
import ch.hslu.informatik.mobpro.intent_and_widget.databinding.ActivityMyMapBinding

class MyMapActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMyMapBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyMapBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.longLat.text = intent.data?.schemeSpecificPart
    }
}
