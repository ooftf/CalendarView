package com.tf.oof.lib;

import java.util.Calendar;

/**
 * Created by 99474 on 2017/12/19 0019.
 */

public class CalendarUtils {

    public static Calendar copyCalendar(Calendar calendar) {
        Calendar result = Calendar.getInstance();
        result.setTime(calendar.getTime());
        return result;
    }
    static int[] fields;

    /**
     * 比较到指定单位field
     * first 大于 second 返回正数
     * first = second 返回0
     * first 小于 second 返回负数
     * @param first
     * @param second
     * @param field
     * @return
     */
    public static int compare(Calendar first,Calendar second,int field){
        for(int temp: getFields()){
            int result = first.get(temp)-second.get(temp);
            //如果结果 两个数不想等，或者只比较到这个单位那么已经得到比较结果
            if(result != 0||field ==temp){
                return result;
            }
        }
        return 0;
    }
    public static int[] getFields(){
        if(fields==null){
            fields = new int[]{Calendar.YEAR,Calendar.MONTH,Calendar.DAY_OF_MONTH,Calendar.HOUR_OF_DAY,Calendar.MINUTE,Calendar.SECOND};
        }
        return fields;
    }
}
