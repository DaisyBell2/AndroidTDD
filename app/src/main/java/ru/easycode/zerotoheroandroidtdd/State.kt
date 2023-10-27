package ru.easycode.zerotoheroandroidtdd

import android.widget.LinearLayout
import android.widget.TextView
import java.io.Serializable

/**
 * @author DaisyBell on 27.10.2023
 */
interface State : Serializable {

    fun apply(linearLayout: LinearLayout, textView: TextView)

    object Initial : State {
        override fun apply(linearLayout: LinearLayout, textView: TextView) = Unit
    }

    object Removed : State {
        override fun apply(linearLayout: LinearLayout, textView: TextView) {
            linearLayout.removeView(textView)
        }
    }

}