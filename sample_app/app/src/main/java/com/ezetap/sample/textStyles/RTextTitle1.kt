package com.ezetap.sample.textstyles

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.ezetap.sample.R

@SuppressLint("AppCompatCustomView")
class RTextTitle1 : TextView {
    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    fun init() {
        val typeface = ResourcesCompat.getFont(context, R.font.lato_bold)
        setTypeface(typeface)
        setTextSize(TypedValue.COMPLEX_UNIT_PX,
                resources.getDimension(R.dimen.text_size_title1))
    }
}