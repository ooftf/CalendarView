# CalendarView
自定义CalendarView,可通过更换DrawModule模块实现自定义日期显示  
在未指定日期的时候CalendarView 显示当前月份  
在未指定DrawModlue使用默认的SimpleDateDrawModule
# 效果图
![demo](https://github.com/ooftf/CalendarView/raw/master/demoImage/demo.gif)
# Gradle配置
```groovy
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
dependencies {
    compile 'com.github.ooftf:CalendarView:1.0.4'
}
```
# 注意事项
当CalendarView已经被系统绘制完毕后，如果改变DrawModule的数据会引起CalendarView变化需要调用CalendarView.invalidate()
重新绘制CalendarView
# 使用方式
```xml
<com.ooftf.calendar.CalendarView
        android:id="@+id/calendarView"
        android:layout_width="match_parent"
        android:layout_height="200dp"
        android:background="@color/White"
        android:paddingBottom="40dp"
        android:paddingLeft="20dp"
        android:paddingRight="10dp"
        android:paddingTop="20dp" />
```
```java
    MyDrawMoudle signDateDrawModule = new MyDrawMoudle(this);
    calendarView.setDateDrawModule(signDateDrawModule);
    Calendar currentMonth = Calendar.getInstance()
    calendarView.setDate(currentMonth); 
```
# 方法
|方法名|描述
|---|---|
|setDateDrawModule|设置日期绘画模块 |
|setDate|设置显示日期|
|setOnItemClickListener|添加点击事件|
# XML属性
|属性名|描述|默认
|---|---|---|
|auto_row|是否自适应行数,false:固定7行，true:每个月是不同的 |false|


