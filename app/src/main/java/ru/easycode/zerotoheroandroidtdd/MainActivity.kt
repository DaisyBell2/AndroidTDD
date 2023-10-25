package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var deletedTextView = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        deletedTextView = savedInstanceState?.getBoolean(KEY) ?: false

        val root = findViewById<LinearLayout>(R.id.rootLayout)
        val textView = findViewById<TextView>(R.id.titleTextView)
        val button = findViewById<CustomButton>(R.id.removeButton)

        if (deletedTextView) root.removeView(textView)

        button.setOnClickListener {
            root.removeView(textView)
            deletedTextView = true
            button.isEnabled = false
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(KEY, deletedTextView)
    }

    companion object {
        private const val KEY = "deletedTextView"
    }
}