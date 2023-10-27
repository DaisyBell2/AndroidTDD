package ru.easycode.zerotoheroandroidtdd

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatButton

/**
 * @author DaisyBell on 26.10.2023
 */
class CustomButton : AppCompatButton {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onSaveInstanceState(): Parcelable? = super.onSaveInstanceState()?.let {
        val visibilityState = VisibilityState(it)
        visibilityState.enabled = isEnabled
        return visibilityState
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val visibilityState = state as VisibilityState?
        super.onRestoreInstanceState(visibilityState?.superState)
        visibilityState?.let {
            isEnabled = it.enabled
        }
    }

}

class VisibilityState : View.BaseSavedState {
    var enabled: Boolean = true

    constructor(superState: Parcelable) : super(superState)
    internal constructor(parcelIn: Parcel) : super(parcelIn) {
        enabled = parcelIn.readInt() == 1
    }

    override fun writeToParcel(out: Parcel, flags: Int) {
        super.writeToParcel(out, flags)
        out.writeInt(if (enabled) 1 else 0)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<VisibilityState> {
        override fun createFromParcel(parcel: Parcel): VisibilityState = VisibilityState(parcel)

        override fun newArray(size: Int): Array<VisibilityState?> = arrayOfNulls(size)
    }

}