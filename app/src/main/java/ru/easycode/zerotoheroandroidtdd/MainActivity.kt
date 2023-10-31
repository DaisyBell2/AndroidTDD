package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val count = Count.Base(2, 4, 0)

    private lateinit var uiState: UiState
    private lateinit var textView: TextView
    private lateinit var incrementButton: CustomButton
    private lateinit var decrementButton: CustomButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.countTextView)
        incrementButton = findViewById(R.id.incrementButton)
        decrementButton = findViewById(R.id.decrementButton)

        incrementButton.setOnClickListener {
            uiState = count.increment(textView.text.toString())
            uiState.apply(incrementButton, decrementButton, textView)
        }

        decrementButton.setOnClickListener {
            uiState = count.decrement(textView.text.toString())
            uiState.apply(incrementButton, decrementButton, textView)
        }

        if (savedInstanceState == null) {
            uiState = count.initial(textView.text.toString())
            uiState.apply(incrementButton, decrementButton, textView)
        }
    }
}