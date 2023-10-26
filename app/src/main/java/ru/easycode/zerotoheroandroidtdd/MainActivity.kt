package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val count = Count.Base(2)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.countTextView)
        val button = findViewById<Button>(R.id.incrementButton)

        button.setOnClickListener {
            textView.text = count.increment(textView.text.toString())
        }
    }
}