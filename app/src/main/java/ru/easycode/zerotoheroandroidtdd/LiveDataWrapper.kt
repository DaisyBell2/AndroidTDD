package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData

interface LiveDataWrapper {

    fun save(bundleWrapper: BundleWrapper.Save)
    fun liveData(): LiveData<UiState>
    interface Update {
        fun update(value: UiState)
    }

    interface Mutable : Update, LiveDataWrapper

    class Base : Mutable {

        private val liveData = SingleLiveEvent<UiState>()
        override fun update(value: UiState) {
            liveData.value = value
        }

        override fun save(bundleWrapper: BundleWrapper.Save) {
            liveData.value?.let { bundleWrapper.save(it) }
        }

        override fun liveData(): LiveData<UiState> = liveData

    }


}
