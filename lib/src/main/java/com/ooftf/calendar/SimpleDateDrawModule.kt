package com.ooftf.calendar

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect

import java.util.Calendar


/**
 * Created by master on 2017/8/10 0010.
 */

class SimpleDateDrawModule internal constructor() : DateDrawModule {
    internal var mDatePaint: Paint
    internal var mPaintTodayBG: Paint

    init {
        mDatePaint = Paint()
        mDatePaint.isAntiAlias = true
        mPaintTodayBG = Paint()
        mPaintTodayBG.isAntiAlias = true
        mPaintTodayBG.color = Color.parseColor("#2EA7E0")
    }

    override fun draw(canvas: Canvas, current: Calendar, cx: Float, cy: Float, compareMonth: Int, width: Float, height: Float) {
        val day = getDay(current).toString()
        if (compareMonth == 0) {
            if (CalendarUtils.compare(current, Calendar.getInstance(), Calendar.DAY_OF_MONTH) == 0) {
                //当前日期
                mDatePaint.color = Color.parseColor("#ff0000")
                canvas.drawCircle(cx, cy, Math.min(width, height) / 3, mPaintTodayBG)
            } else {
                //非当前日期
                mDatePaint.color = Color.parseColor("#000000")
            }
        } else {
            mDatePaint.color = Color.parseColor("#999999")
        }

        drawText(day, cx, cy, canvas, mDatePaint)
    }

    fun getDay(calendar: Calendar): Int {
        return calendar.get(Calendar.DAY_OF_MONTH)
    }

    override fun drawHeader(canvas: Canvas, value: String, index:Int,cx: Float, cy: Float, width: Float, height: Float) {
        mDatePaint.textSize = Math.min(width, height) / 3
        drawText(value, cx , cy, canvas, mDatePaint)
    }

    /**
     * 以x和y为中心绘画文字内容，普通drawText中x,y为文字的左下角；
     * @param text
     * @param x
     * @param y
     * @param canvas
     * @param paint
     */
    fun drawText(text: String, x: Float, y: Float, canvas: Canvas, paint: Paint) {
        val rect = Rect()
        paint.getTextBounds("A", 0, 1, rect)
        val halfH = (rect.height() / 2).toFloat()
        val halfW = paint.measureText(text) / 2
        canvas.drawText(text, x - halfW, y + halfH, paint)
    }
}
