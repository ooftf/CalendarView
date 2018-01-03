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
        var calendar = Calendar.getInstance()
        var year = calendar.get(Calendar.YEAR)
        var month = calendar.get(Calendar.MONTH)+1
        list.add(BoxBean(year, month, 11, false))
        list.add(BoxBean(year, month, 12, false))
        list.add(BoxBean(year, month, 15, false))
        list.add(BoxBean(year, month, 19, false))
        list.add(BoxBean(year, month, 21, false))
        list.add(BoxBean(year, month, 26, false))
        Handler().postDelayed({//模拟网络请求
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
