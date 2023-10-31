package ru.easycode.zerotoheroandroidtdd

import android.widget.TextView

/**
 * @author DaisyBell on 26.10.2023
 */
interface UiState {

    fun apply(incrementButton: CustomButton, decrementButton: CustomButton, textView: TextView)

    data class Base(private val text: String) : UiState {
        override fun apply(
            incrementButton: CustomButton,
            decrementButton: CustomButton,
            textView: TextView
        ) {
            textView.text = text
            incrementButton.isEnabled = true
            decrementButton.isEnabled = true
        }
    }

    data class Max(private val text: String) : UiState {
        override fun apply(
            incrementButton: CustomButton,
            decrementButton: CustomButton,
            textView: TextView
        ) {
            textView.text = text
            incrementButton.isEnabled = false
            decrementButton.isEnabled = true
        }
    }

    data class Min(private val text: String) : UiState {
        override fun apply(
            incrementButton: CustomButton,
            decrementButton: CustomButton,
            textView: TextView
        ) {
            textView.text = text
            incrementButton.isEnabled = true
            decrementButton.isEnabled = false
        }
    }
}