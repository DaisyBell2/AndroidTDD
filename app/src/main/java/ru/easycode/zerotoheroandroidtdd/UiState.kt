package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView

/**
 * @author DaisyBell on 26.10.2023
 */
interface UiState {

    fun apply(textView: TextView, button: Button)

    data class Base(private val text: String) : UiState {
        override fun apply(textView: TextView, button: Button) {
            textView.text = text
        }
    }

    data class Max(private val text: String) : UiState {
        override fun apply(textView: TextView, button: Button) {
            textView.text = text
            button.isEnabled = false
        }
    }
}