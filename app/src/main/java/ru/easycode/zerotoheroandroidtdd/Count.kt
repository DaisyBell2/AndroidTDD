package ru.easycode.zerotoheroandroidtdd

/**
 * @author DaisyBell on 26.10.2023
 */
interface Count {

    fun increment(number: String): UiState

    class Base(private val step: Int, private val max: Int) : Count {
        init {
            if (step <= 0)
                throw IllegalStateException("step should be positive, but was $step")
            else if (max <= 0)
                throw IllegalStateException("max should be positive, but was $max")
            else if (step > max)
                throw IllegalStateException("max should be more than step")
        }

        override fun increment(number: String): UiState {
            val result = (number.toInt() + step).toString()
            return if (result.toInt() + step > max)
                UiState.Max(result)
            else
                UiState.Base(result)
        }

    }
}