package ru.easycode.zerotoheroandroidtdd

import java.net.UnknownHostException

/**
 * @author DaisyBell on 21.02.2024
 */
interface Repository {

    suspend fun load(): LoadResult

    class Base(
        private val service: SimpleService,
        private val url: String
    ) : Repository {
        override suspend fun load(): LoadResult = try {
            LoadResult.Success(service.fetch(url))
        } catch (e: Exception) {
            LoadResult.Error(noConnection = e is UnknownHostException)
        }
    }

}