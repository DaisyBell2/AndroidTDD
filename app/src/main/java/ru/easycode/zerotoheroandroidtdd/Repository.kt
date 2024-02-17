package ru.easycode.zerotoheroandroidtdd

import kotlinx.coroutines.delay

/**
 * @author DaisyBell on 29.10.2023
 */
interface Repository {

    suspend fun load()
    class Base : Repository {
        override suspend fun load() {
            delay(3500)
        }

    }
}