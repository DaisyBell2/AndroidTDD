package ru.easycode.zerotoheroandroidtdd

/**
 * @author DaisyBell on 26.10.2023
 */
interface Count {

    fun increment(number: String): String
    class Base(private val step: Int) : Count {
        init {
            if (step <= 0)
                throw IllegalStateException("step should be positive, but was $step")
        }

        override fun increment(number: String): String {
            return (number.toInt() + step).toString()
        }

    }
}