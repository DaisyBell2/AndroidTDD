package ru.easycode.zerotoheroandroidtdd

/**
 * @author DaisyBell on 26.10.2023
 */
interface Count {

    fun increment(number: String): UiState

    class Base(private val step: Int, private val max: Int) : Count {
        init {
            if (step < 1)
                throw IllegalStateException("step should be positive, but was $step")
            if (max < 1)
                throw IllegalStateException("max should be positive, but was $max")
            if (max < step)
                throw IllegalStateException("max should be more than step")
        }

        override fun increment(number: String): UiState {
            val digits = number.toInt()
            val result = digits + step
            return if (result + step > max)
                UiState.Max(result.toString())
            else
                UiState.Base(result.toString())
        }
    }
}