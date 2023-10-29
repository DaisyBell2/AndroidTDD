package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * @author DaisyBell on 29.10.2023
 */
interface LiveDataWrapper {

    fun update(value: UiState)
    fun liveData(): LiveData<UiState>

    class Base(
        private val textView: TextView,
        private val progressBar: ProgressBar,
        private val button: Button
    ) : LiveDataWrapper {

        private var _liveData = MutableLiveData<UiState>(UiState.Empty)
        private val liveData: LiveData<UiState>
            get() = _liveData

        override fun update(value: UiState) {
            _liveData.apply { postValue(value) }
            value.apply(textView, progressBar, button)
        }

        override fun liveData(): LiveData<UiState> {
            return liveData
        }

    }
}