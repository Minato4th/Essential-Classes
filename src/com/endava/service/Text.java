package com.endava.service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 3/28/2017
 */
public class Text {

    private static SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    private static Date dateStart;
    private static Date dateEnd;

    public static void start(){
        System.out.println("Please enter the number regarding next patterns :\n");
    }

    public static void numberFormat(){
        System.out.println( "+373 60 066006\n" +
                            "+(373)-79-85-85-85\n" +
                            "+373 79 666-999\n");
    }

    public static void money(){
        System.out.println("Please insert number between 10 and 500");
    }

    public static void moneyError(){
        System.out.println("Out of range, please insert number between 10 and 500");
    }

    public static void request(String number, int money){
        System.out.println("\n" +
                "Your number " + number + "\n" +
                "Your money " + money + "$" + "\n\n" +
                "Buy!");
    }

    public static void incorrect(){
        System.out.println("Sorry incorrect number or money range");
    }

    public static void in(String methodName){
        dateStart = new Date(System.currentTimeMillis());
        System.out.println("Start from : " + format.format(dateStart) + ", Starting Method - " + methodName);
    }

    public static void out(String methodName){
        dateEnd = new Date(System.currentTimeMillis());
        System.out.println("End in : " + format.format(dateEnd) + ", Ending Method - " + methodName);
        System.out.println("Time elapsed : " + ((dateEnd.getTime() - dateStart.getTime())/1000) + "sec");
    }
}
