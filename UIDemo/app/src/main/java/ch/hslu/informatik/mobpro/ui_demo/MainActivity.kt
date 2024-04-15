package ch.hslu.informatik.mobpro.ui_demo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.Date

class MainActivity : AppCompatActivity() {

    private val MY_ACTION_SHOW_TEXT = "ch.hslu.mobpro.actions.SHOW_TEXT"
    private val MY_EXTRA_KEY = "text"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = getString(R.string.app_name)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.activity_main_fragment_container, MainFragment.newInstance())
                .commit()
        }

        if (intent.action == MY_ACTION_SHOW_TEXT) {
            val text = intent.getStringExtra(MY_EXTRA_KEY)
            findViewById<TextView>(R.id.EigeneAction).text = text
        }

        val showTextButton = findViewById<Button>(R.id.buttonIntentMitEigenerActionStarten)
        showTextButton.setOnClickListener {
            startCustomIntentOnClick()
        }
    }

    private fun startCustomIntentOnClick() {
        val customIntent = Intent()
        customIntent.action = MY_ACTION_SHOW_TEXT
        val myText ="""Activity gestartet durch folgende Intent-ACTION:
        '$MY_ACTION_SHOW_TEXT'
        Jetzt = ${Date()}""".trimIndent()
        customIntent.putExtra(MY_EXTRA_KEY, myText)
        startActivity(customIntent)
    }
}