package com.endava.util;

import com.endava.service.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 3/28/2017
 */
public class Validator {


    private BufferedReader reader;
    private String string;
    private Pattern pattern1;
    private Pattern pattern2;
    private Pattern pattern3;
    private Matcher matcher;

    public Validator(){
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.pattern1 = Pattern.compile("(^[+])(\\d{3})(\\s)(\\d{2})(\\s)([0-9]{6}$)");
        this.pattern2 = Pattern.compile("(^[+])([(]\\d{3}[)])([-])(\\d{2})([-])(\\d{2})([-])(\\d{2})([-])(\\d{2})");
        this.pattern3 = Pattern.compile("(^[+])(\\d{3})(\\s)(\\d{2})(\\s)(\\d{3})([-])(\\d{3})");
    }

    public String isString(){

        for (int i = 0; i < 3; i++) {
            try {
                this.string = reader.readLine();
                i = 5;
            } catch (IOException e) {
                System.out.println("Something go wrong, try again");
            }
        }

        return string;
    }

    public int isDigit(){

        for (int j = 0; j < 3; j++) {
            boolean right = true;
            String numS = isString();
            for (int i = 0; i < numS.length(); i++) {
                if (!Character.isDigit(numS.charAt(i))){
                    System.out.println("Wrong number format, please try again");
                    right = false;
                    break;
                }
            }

            if (right) {
                j = 5;
                this.string = numS;
            }
        }

        return Integer.parseInt(this.string);
    }

    public String isNumber(){

        Text.in("Inserting Number");

        for (int i = 0; i < 4; i++) {
            string = isString();

            if (correct(string)){
                i = 5;
            } else {
                System.out.println("Incorrect number format, please insert using next formats");
                Text.numberFormat();
            }
        }

        Text.out("Inserting Number");

        return string;
    }

    public boolean correct(String number){
        boolean isNumber = false;

        if ((matcher = pattern1.matcher(number)).matches()){
            isNumber = true;
        } else if (((matcher = pattern2.matcher(number)).matches())) {
            isNumber = true;
        } else if (((matcher = pattern3.matcher(number)).matches())) {
            isNumber = true;
        }

        return isNumber;
    }

    public int isMoney(){
        Text.in("Inserting Money");
        Text.money();
        int money = 0;

        for (int i = 0; i < 3; i++) {
            money = isDigit();
            if (money <= 500 && money >= 10){
                i = 5;
            } else {
                Text.moneyError();
            }
        }

        Text.out("Inserting Money");
        return money;
    }

}
