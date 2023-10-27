package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val count = Count.Base(STEP, MAX, MIN)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.countTextView)
        val buttonIncrement = findViewById<CustomButton>(R.id.incrementButton)
        val buttonDecrement = findViewById<CustomButton>(R.id.decrementButton)

        buttonIncrement.setOnClickListener {
            textView.text = count.increment(textView.text.toString()).show()
            buttonDecrement.isEnabled = true
            if (textView.text.toString() == MAX.toString())
                buttonIncrement.isEnabled = false
        }

        buttonDecrement.setOnClickListener {
            textView.text = count.decrement(textView.text.toString()).show()
            buttonIncrement.isEnabled = true
            if (textView.text.toString() == MIN.toString())
                buttonDecrement.isEnabled = false
        }

        count.initial("0")
    }

    companion object {
        const val STEP = 2
        const val MAX = 4
        const val MIN = 0
    }
}