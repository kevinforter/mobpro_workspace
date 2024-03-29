package ch.hslu.mopro.firstappfinal.lifecyclelog

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import ch.hslu.mopro.firstappfinal.R

class LifecycleLogFragment : Fragment(R.layout.fragment_lifecycle_logger) {

    companion object {
        fun newInstance(): LifecycleLogFragment {
            return LifecycleLogFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("hslu_mobApp", "Fragment onCreate() aufgerufen")
    }

    // TODO: Add further implementions of onX-methods.
    override fun onStart() {
        super.onStart()
        Log.i("hslu_mobApp", "Fragment onStart() aufgerufen")
    }

    override fun onResume() {
        super.onResume()
        Log.i("hslu_mobApp", "Fragment onResume() aufgerufen")
    }

    override fun onPause() {
        super.onPause()
        Log.i("hslu_mobApp", "Fragment onPause() aufgerufen")
    }

    override fun onStop() {
        super.onStop()
        Log.i("hslu_mobApp", "Fragment onStop() aufgerufen")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("hslu_mobApp", "Fragment onDestroy() aufgerufen")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i("hslu_mobApp", "Fragment onSaveInstanceState() aufgerufen")
    }
}
