package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * @author DaisyBell on 30.10.2023
 */
class MainViewModel(
    private val liveDataWrapper: LiveDataWrapper,
    private val repository: Repository
) : ViewModel() {

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    fun load() {
        liveDataWrapper.update(UiState.ShowProgress)
        scope.launch(Dispatchers.IO) {
            repository.load()
            withContext(Dispatchers.Main) {
                liveDataWrapper.update(UiState.ShowData)
            }
        }
    }

    fun save(bundleWrapper: BundleWrapper.Save) {
        liveDataWrapper.save(bundleWrapper)
    }

    fun restore(bundleWrapper: BundleWrapper.Restore) {
        val uiState = bundleWrapper.restore()
        liveDataWrapper.update(uiState)
    }

    override fun onCleared() {
        super.onCleared()
        scope.cancel()
    }
}