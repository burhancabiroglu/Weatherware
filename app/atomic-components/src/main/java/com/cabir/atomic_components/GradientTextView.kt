package com.cabir.atomic_components

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import android.graphics.Shader

import android.graphics.LinearGradient





class GradientTextView : androidx.appcompat.widget.AppCompatTextView {



    private var startColor:Int = 0;
    private var endColor:Int = 0;


    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init(attrs, defStyle)
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        val a = context.obtainStyledAttributes(attrs, R.styleable.GradientTextView, defStyle, 0)

        startColor = a.getColor(R.styleable.GradientTextView_startColor,0)
        endColor = a.getColor(R.styleable.GradientTextView_endColor,0)

        a.recycle()

    }


    @SuppressLint("DrawAllocation")
    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)

        if (changed) {
            paint.shader = LinearGradient(
                0f, 0f, 0f, height.toFloat(),
                endColor, startColor,
                Shader.TileMode.CLAMP
            )
        }
    }

}