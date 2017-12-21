package com.ooftf.calendarview

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.ooftf.calendar.CalendarUtils
import com.ooftf.calendar.DateDrawModule
import java.util.*
import kotlin.collections.ArrayList


/**
 * Created by 99474 on 2017/12/21 0021.
 */
class MyDrawModule(var context: Context) : DateDrawModule {
    var headerPaint: Paint = Paint()
    var dayPaint: Paint = Paint()
    var todayBackground: Paint = Paint()
    var boxList: MutableList<BoxBean> = ArrayList()
    var openBitmap: Bitmap = CanvasUtils.getBitmapFromVectorId(context, R.drawable.vector_box_open)
    var closeBitmap: Bitmap = CanvasUtils.getBitmapFromVectorId(context, R.drawable.vector_box_close)

    init {
        headerPaint.isAntiAlias = true
        dayPaint.isAntiAlias = true
        todayBackground.isAntiAlias = true
        headerPaint.textSize = CanvasUtils.dip2px(context,14.toDouble()).toFloat()
        dayPaint.textSize = CanvasUtils.dip2px(context,12.toDouble()).toFloat()
        todayBackground.color = Color.parseColor("#2196F3")
    }

    override fun drawDay(canvas: Canvas, current: Calendar, cx: Float, cy: Float, compareMonth: Int, width: Float, height: Float) {
        if (drawBox(canvas, current, cx, cy, width, height)) return
        val day = current.get(Calendar.DAY_OF_MONTH).toString()
        if (compareMonth == 0) {
            if (CalendarUtils.compare(current, Calendar.getInstance(), Calendar.DAY_OF_MONTH) == 0) {
                //今天
                dayPaint.color = Color.parseColor("#ff0000")
                canvas.drawCircle(cx, cy, Math.min(width, height) / 3, todayBackground)
            } else {
                //非今天
                dayPaint.color = Color.parseColor("#000000")
            }
        } else {
            //非日历所要显示的月份
            dayPaint.color = Color.parseColor("#999999")
        }
        CanvasUtils.drawTextByCenter(day, cx, cy, canvas, dayPaint)
    }

    override fun drawHeader(canvas: Canvas, value: String, index: Int, cx: Float, cy: Float, width: Float, height: Float) {
        CanvasUtils.drawTextByCenter(value, cx, cy, canvas, headerPaint)
    }


    private fun drawBox(canvas: Canvas, calendar: Calendar, cx: Float, cy: Float, width: Float, height: Float): Boolean {
        boxList.forEach {
            if (calendar.get(Calendar.YEAR) == it.year && calendar.get(Calendar.MONTH) + 1 == it.month && calendar.get(Calendar.DAY_OF_MONTH) == it.day) {
                var bitmap: Bitmap =
                        if (it.isOpen) {
                            openBitmap
                        } else {
                            closeBitmap
                        }
                var scale = Math.min(width / bitmap.width, height / bitmap.height)//计算合适的缩放比例
                CanvasUtils.drawBitmapByCenter(canvas, bitmap, todayBackground, cx, cy, bitmap.width * scale, bitmap.height * scale)
                return true
            }
        }
        return false
    }
}