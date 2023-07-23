package org.example;

import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        int days = 180;
        int [] a = Nagruzka(days);
  //      for (int i = 0; i < 180; i++) {
  //      System.out.println(a[i]);}
        user d = new user("Dimay",34 );
        ArrayList<user> list = new ArrayList<>();
        list.add(d);
        user y = list.get(0);
        String c = y.Name;
        int d3 = y.age;
  //      System.out.println(c);
 //       System.out.println(d3);
//        y.create();
//        y.download();
        SportCalendar aw = new SportCalendar(1, 23);
        aw.getNowDate();
        aw.eventCalendar();
    }
    public static int [] Nagruzka(int days) {
        int [] a = new int [180];
            for (int i = 0; i < 180; i++) { a[i]=i;}
        return a;
    }

}