package ru.easycode.zerotoheroandroidtdd

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatTextView

/**
 * @author DaisyBell on 30.10.2023
 */
class CustomTextView : AppCompatTextView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onSaveInstanceState(): Parcelable? = super.onSaveInstanceState()?.let {
        val visibilityState = VisibilityState(it)
        visibilityState.visible = visibility
        return visibilityState
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val visibilityState = state as VisibilityState?
        super.onRestoreInstanceState(visibilityState?.superState)
        visibilityState?.let {
            visibility = it.visible
        }
    }
}

class VisibilityState : View.BaseSavedState {
    var visible: Int = View.VISIBLE

    constructor(superState: Parcelable) : super(superState)
    internal constructor(parcelIn: Parcel) : super(parcelIn)

    override fun writeToParcel(out: Parcel, flags: Int) {
        super.writeToParcel(out, flags)
        out.writeInt(visible)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<VisibilityState> {
        override fun createFromParcel(parcel: Parcel): VisibilityState = VisibilityState(parcel)

        override fun newArray(size: Int): Array<VisibilityState?> = arrayOfNulls(size)
    }

}