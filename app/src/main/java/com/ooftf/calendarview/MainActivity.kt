package com.ooftf.calendarview

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var module: MyDrawModule
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        module = MyDrawModule(this)
        calendarView2.setDate(2017, 1)
        calendarView.setDateDrawModule(module)
        var list = ArrayList<BoxBean>()
        list.add(BoxBean(2017, 12, 11, false))
        list.add(BoxBean(2017, 12, 12, false))
        list.add(BoxBean(2017, 12, 15, false))
        list.add(BoxBean(2017, 12, 19, false))
        list.add(BoxBean(2017, 12, 21, false))
        list.add(BoxBean(2017, 12, 26, false))
        Handler().postDelayed({
            module.boxList = list
            calendarView.invalidate()
        }, 2000)
        calendarView.setOnItemClickListener { calendar ->
            module.boxList.forEach {
                if (calendar.get(Calendar.YEAR) == it.year && calendar.get(Calendar.MONTH) + 1 == it.month && calendar.get(Calendar.DAY_OF_MONTH) == it.day) {
                    it.isOpen = !it.isOpen
                    calendarView.invalidate()
                }
            }
        }
    }
}
