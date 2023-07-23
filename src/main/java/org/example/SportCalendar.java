package org.example;

import java.util.Date;
import java.util.GregorianCalendar;

public class SportCalendar {
    int period;
    int nowDate;


    public SportCalendar(int period, int nowDate) {
        this.period = period;
        this.nowDate = nowDate;
    }

    public Date getNowDate () {
        GregorianCalendar calendar = new GregorianCalendar(2017, 0 , 25);
        Date nowDate1 = calendar.getTime();
        System.out.println(nowDate1);
        return nowDate1;
    }

}
