package org.example;

import java.text.SimpleDateFormat;
import java.util.*;

public class SportCalendar {
    int period;
    int nowDate;

    ArrayList<Date> allEvents;


    public SportCalendar(int period, int nowDate) {
        this.period = period;
        this.nowDate = nowDate;
    }

    public Date getNowDate () {
        Date nowDate1 = new Date();
        System.out.println(nowDate1);
        return nowDate1;
    }

    public Map<Integer, Date> eventCalendar () {
        int [][] calend = new int[365][10];
        Map<Integer,Date> eventSeq = new HashMap<>();
        ArrayList<Date> eventA = new ArrayList<>();
        ArrayList<Date> eventB = new ArrayList<>();
        ArrayList<Date> eventC = new ArrayList<>();
        ArrayList<Date> eventAll = new ArrayList<>();
        Date nowDate1 = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd");
        formatForDateNow.format(nowDate1);
        // получаем даты от спортсмена
        System.out.println("Выберем даты основных соревнований за сезон, не более 3");

        Scanner in = new Scanner(System.in);
        for (int i=0; i<3; i++) {
            String date = in.next();
            Date date1 = getDif(date);
            long difference = date1.getTime() - nowDate1.getTime();
            int days =  (int)(difference / (24 * 60 * 60 * 1000));
            System.out.println(days + " дн.");
            calend[days][0] = days;
            calend[days][1] = 1;
            eventA.add(date1);
            eventAll.add(date1);
        }
        System.out.println("Выберем даты важных соревнований за сезон, не более 6");
        for (int i=0; i<6; i++) {
            String date = in.next();
            Date date1 = getDif(date);
            long difference = date1.getTime() - nowDate1.getTime();
            int days =  (int)(difference / (24 * 60 * 60 * 1000));
            System.out.println(days + " дн.");
            calend[days][0] = days;
            calend[days][1] = 2;
            eventB.add(date1);
            eventAll.add(date1);
        }
        System.out.println("Выберем даты промежуточных соревнований за сезон, не более 9");
        for (int i=0; i<9; i++) {
            String date = in.next();
            Date date1 = getDif(date);
            long difference = date1.getTime() - nowDate1.getTime();
            int days =  (int)(difference / (24 * 60 * 60 * 1000));
            System.out.println(days + " дн.");
            calend[days][0] = days;
            calend[days][1] = 3;
            eventC.add(date1);
            eventAll.add(date1);
        }
        for(Date counter: allEvents){
            System.out.println(counter);
        }           /* Sort statement*/
        Collections.sort(allEvents);
        System.out.println("После:");
        for(Date counter: allEvents){
            System.out.println(counter);
        }

        System.out.println(nowDate1);
    return eventSeq;
    }

    public Date getDif (String str) {


        //получаем строку с датой введенной хз как пользователем
        String st = str;
        //переводим в формат SimpleDate
        int year = (Integer.parseInt(String.valueOf(str.charAt(6))))*1000+(Integer.parseInt(String.valueOf(str.charAt(7))))*100+(Integer.parseInt(String.valueOf(str.charAt(8))))*10+(Integer.parseInt(String.valueOf(str.charAt(9))));
        int month = (Integer.parseInt(String.valueOf(str.charAt(3))))*10+(Integer.parseInt(String.valueOf(str.charAt(4))));
        int day = (Integer.parseInt(String.valueOf(str.charAt(0))))*10+(Integer.parseInt(String.valueOf(str.charAt(1))));
        String date1 = year+"."+month+"."+day;


        Date date2 = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd");
        formatForDateNow.format(date2);


        Date dateOne = null;
        Date dateTwo = date2;

        try {
            dateOne = formatForDateNow.parse(date1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Количество дней между датами в миллисекундах
        long difference = dateOne.getTime() - dateTwo.getTime();
        // Перевод количества дней между датами из миллисекунд в дни
        int days =  (int)(difference / (24 * 60 * 60 * 1000)); // миллисекунды / (24ч * 60мин * 60сек * 1000мс)
        // Вывод разницы между датами в днях на экран
        System.out.println(days + " дн.");

        return dateOne;
    }
}
