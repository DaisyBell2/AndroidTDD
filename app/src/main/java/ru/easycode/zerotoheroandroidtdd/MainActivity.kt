package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val count = Count.Base(2, 10)
    private var countClick = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.countTextView)
        val button = findViewById<CustomButton>(R.id.incrementButton)

        button.setOnClickListener {
            countClick++
            textView.text = count.increment(textView.text.toString()).show()
            if (countClick == 2)
                button.isEnabled = false
        }
    }
}