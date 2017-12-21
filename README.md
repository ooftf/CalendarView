# CalendarView
自定义CalendarView,可通过更换DrawModule模块实现自定义日期显示  
在未指定日期的时候CalendarView 显示当前月份  
在未指定DrawModlue使用默认的SimpleDateDrawModule  
# Gradle配置
```groovy
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
dependencies {
    compile 'com.github.ooftf:CalendarView:1.0.2'
}
```
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
    SignDateDrawModule signDateDrawModule = new SignDateDrawModule(this);
    calendarView.setDateDrawModule(signDateDrawModule);
    Calendar currentMonth = Calendar.getInstance()
    calendarView.setDate(currentMonth);
```
# 方法
* setDateDrawModule：设置日期绘画模块  
* setDate：设置显示日期  
