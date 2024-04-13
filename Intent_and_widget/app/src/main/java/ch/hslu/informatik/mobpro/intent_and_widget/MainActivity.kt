package ch.hslu.informatik.mobpro.intent_and_widget

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import ch.hslu.informatik.mobpro.intent_and_widget.R

class MainActivity : AppCompatActivity() {

    private val gmmIntentUri = Uri.parse("geo:37.7749,-122.4194")
    private val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)

    @SuppressLint("MissingInflatedId")
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
    }
}
