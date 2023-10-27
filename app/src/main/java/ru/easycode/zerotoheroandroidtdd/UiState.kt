package ru.easycode.zerotoheroandroidtdd

/**
 * @author DaisyBell on 26.10.2023
 */
interface UiState {

    fun show(): String

    data class Base(private val text: String) : UiState {
        override fun show(): String = text
    }

    data class Max(private val text: String) : UiState {
        override fun show(): String = text
    }

    data class Min(private val text: String) : UiState {
        override fun show(): String = text
    }
}