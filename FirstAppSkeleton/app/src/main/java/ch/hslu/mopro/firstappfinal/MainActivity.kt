package ch.hslu.mopro.firstappfinal

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import ch.hslu.mopro.firstappfinal.lifecyclelog.LifecycleLogActivity

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    companion object {
        val QUESTION = "question"
        val ANSWER = "answer"
    }

    private val openQuestionActivity =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            //TODO check if the result is ok and set the content to the textview
            if (result.resultCode == RESULT_OK) {
                val answer = result.data?.getStringExtra(ANSWER)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<Button>(R.id.main_button_logActivity).setOnClickListener { startLogActivity() }
        findViewById<Button>(R.id.main_button_startBrowser).setOnClickListener { startBrowser() }
        findViewById<Button>(R.id.main_button_questionActivity).setOnClickListener { startQuestionActivity() }
    }


    private fun startLogActivity() {
        // TODO: start LifecylceLogActivity mit LifecycleLogFragment
        val intent = Intent(this, LifecycleLogActivity::class.java)
        startActivity(intent)
    }

    private fun startBrowser() {
        // TODO: start Browser with http://www.hslu.ch
        val url = "http://www.hslu.ch"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    private fun startQuestionActivity() {
        // TODO: launch QuestionActivity with Intent
        val questionText = "Und, wie läuft’s so..."
        val intent = Intent(this, QuestionActivity::class.java).apply {
            putExtra(QUESTION, questionText)
        }
        openQuestionActivity.launch(intent)
    }
}