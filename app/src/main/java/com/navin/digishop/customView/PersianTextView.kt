package com.navin.digishop.customView

import android.content.Context
import androidx.appcompat.widget.AppCompatTextView
import android.graphics.Typeface
import android.util.AttributeSet

class PersianTextView : AppCompatTextView {
    constructor(context: Context) : super(context) {
        font(context)
    }

    private fun font(context: Context) {
        val typeface = Typeface.createFromAsset(context.assets, "fonts/irsans.ttf")
        setTypeface(typeface)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        font(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        font(context)
    }
}