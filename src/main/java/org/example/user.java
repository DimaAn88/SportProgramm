package org.example;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Scanner;
import java.util.Set;

public class user {
    String Name;
    int age;
    int weekkm;
    int rec5km;
    int rec100m;
    int weekTrain;
    int level;
    public user(String Name, int age) {
        this.Name = Name;
        this.age = age;
    }

    public void create() {
        System.out.println("Введите ваше имя");
        Scanner in = new Scanner(System.in);
        Name = in.next();
        String fileName = Name + ".txt";
        System.out.println("Введите ваш возраст");
        age = in.nextInt();
        System.out.println("Введите недельный километраж км/неделю за последние 3 недели");
        weekkm = in.nextInt();
        System.out.println("Введите ваше лучшее время на дистанции 5 км");
        String rec5km1 = in.next();
        System.out.println("Введите ваше лучшее время на дистанции 100 м, через точку");
        float rec100m1 = in.nextFloat();
        System.out.println("Введите какое количество занятий в неделю приемлимо вам");
        weekTrain = in.nextInt();
        // расчет уровня пользователя
        rec5km = Integer.parseInt(String.valueOf(rec5km1.charAt(0)));
        rec5km = (rec5km*10+Integer.parseInt(String.valueOf(rec5km1.charAt(1))))*60+(Integer.parseInt(String.valueOf(rec5km1.charAt(3))))*10+Integer.parseInt(String.valueOf(rec5km1.charAt(4)));
        System.out.println(rec5km);

        if (rec5km < 1030) {
            level = 4;
        }
        if (rec5km < 1200) {
            level = 3;
        }
        if (rec5km < 1500) {
            level = 2;
        }
        if (rec5km > 1499) {
            level = 1;
        }
        System.out.println(level);

// создание новой папки под пользователя
        Set<PosixFilePermission> perms =
                PosixFilePermissions.fromString("rwxr-x---");
        FileAttribute<Set<PosixFilePermission>> attr =
                PosixFilePermissions.asFileAttribute(perms);
        Path file = Path.of(Name);
        try {
            Files.createDirectory(file, attr);

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        System.out.println(file.getRoot());
        String fileway = Name+"/"+Name+".txt";
   // запись данных пользователя
        try (FileWriter writer = new FileWriter(fileway, false)) {
            // запись всей строки
            String userData = Name;
            int len = userData.length();
            System.out.println(len);
            int addlen = 10 - len;
            if (addlen > 0) {
                for (int i = 0; i < addlen; i++) {
                    userData = userData + "0";
                }
            }

            userData = userData + age;
            if (weekkm < 100) {
                userData = userData+"0";
            }
            userData = userData + weekkm;
            if (rec5km<1000) {
                userData = userData + "0";
            }
            userData = userData + rec5km +weekTrain+level;
            System.out.println("то что пишется в файл");
            System.out.println(userData);

            writer.write(userData, 0, 21);
            // запись по символам
            writer.append('\n');
            writer.append('E');

            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage()); //эта конструкция позволяет не выдавать ошибку если файл или папка уже есть
        }
        //cоздание папки тренировки в папке пользователя
        Set<PosixFilePermission> perms2 =
                PosixFilePermissions.fromString("rwxr-x---");
        FileAttribute<Set<PosixFilePermission>> attr2 =
                PosixFilePermissions.asFileAttribute(perms2);
        String  createTrainPack = Name+"/"+"trainings";
        Path file2 = Path.of(createTrainPack);
        try {
            Files.createDirectory(file2, attr2);

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }


}

    public void download(){
        System.out.println("Введите ваше имя");
        Scanner in = new Scanner(System.in);
        Name = in.next();
        String fileName = Name+"/"+Name+".txt";
    try(FileReader reader = new FileReader(fileName))
    {
        // читаем посимвольно все данные пользователя
        int c;
        String name = "";
        String age2 = "возраст -";
        int j1 = 0;
        String weekkm2 = "километраж - ";


        while((c=reader.read())!=-1){
        j1 +=1;
        if (j1<11) {
            if (c != 48) {
                name = name + ((char) c);
            }
        }
        if ((j1>10) & (j1<13)) {
            age2 = age2 + ((char) c);
        }
        if ((j1>12) & (j1<16)) {
            weekkm2 = weekkm2 + ((char) c);
        }
        if (j1==20) {
            level =  Integer.parseInt(String.valueOf((char) c));
        }
        if (j1==21)  {
            weekTrain = Integer.parseInt(String.valueOf((char) c));
        }

        }
        System.out.println("то что выводится :");
        System.out.println(name);
        System.out.println(age2);
        System.out.println(weekkm2);
        System.out.println(level);
        System.out.println(weekTrain);
    }
        catch(IOException ex){

        System.out.println(ex.getMessage());
    }
}


}
