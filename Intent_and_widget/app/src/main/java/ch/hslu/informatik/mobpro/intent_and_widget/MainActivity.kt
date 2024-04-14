package ch.hslu.informatik.mobpro.intent_and_widget

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.util.Date

class MainActivity : AppCompatActivity() {

    private val gmmIntentUri = Uri.parse("geo:37.7749,-122.4194")
    private val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
    private val MY_ACTION_SHOW_TEXT = "ch.hslu.mobpro.actions.SHOW_TEXT"
    private val MY_EXTRA_KEY = "text"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mapButton = findViewById<Button>(R.id.buttonMapIntentStart)
        mapButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            startActivity(intent)
        }

        val resolveList = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            packageManager
                .queryIntentActivities(
                    mapIntent,
                    PackageManager.ResolveInfoFlags.of(PackageManager.MATCH_DEFAULT_ONLY.toLong())
                )
        } else {
            packageManager
                .queryIntentActivities(
                    mapIntent,
                    PackageManager.MATCH_DEFAULT_ONLY
                )
        }

        val queryButton = findViewById<Button>(R.id.buttonMapIntentsAnfragen)
        queryButton.setOnClickListener {
            val activityNames = resolveList.map { it.activityInfo.name }

            AlertDialog.Builder(this)
                .setTitle("Alle Map Activities gemäss Intent-Abfrage")
                .setMessage(activityNames.joinToString("\n\n"))
                .setPositiveButton("DANKE, PACKAGEMANAGER!") { dialog, _ -> dialog.dismiss() }
                .show()
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
