package ru.easycode.zerotoheroandroidtdd

/**
 * @author DaisyBell on 26.10.2023
 */
interface Count {

    fun initial(number: String): UiState
    fun increment(number: String): UiState
    fun decrement(number: String): UiState

    class Base(private val step: Int, private val max: Int, private val min: Int) : Count {
        init {
            if (step <= 0)
                throw IllegalStateException("step should be positive, but was $step")
            else if (max <= 0)
                throw IllegalStateException("max should be positive, but was $max")
            else if (step > max)
                throw IllegalStateException("max should be more than step")
        }

        override fun initial(number: String): UiState {
            return if (number.toInt() == min)
                UiState.Min(number)
            else if (number.toInt() == max)
                UiState.Max(number)
            else
                UiState.Base(number)
        }

        override fun increment(number: String): UiState {
            val result = (number.toInt() + step).toString()
            return if (result.toInt() == max)
                UiState.Max(result)
            else
                UiState.Base(result)
        }

        override fun decrement(number: String): UiState {
            val result = (number.toInt() - step).toString()
            return if (result.toInt() == min)
                UiState.Min(result)
            else
                UiState.Base(result)
        }

    }
}