package com.endava.service;

import com.endava.util.Validator;

/**
 * 3/28/2017
 */
public class Menu {
    
    private String number;
    private int money;
    private Validator validator;
    
    public Menu(){
        validator = new Validator();
    }

    public void mainMenu(){

        Text.start();
        Text.numberFormat();

        number = validator.isNumber();
        if (validator.correct(number)){
            money = validator.isMoney();
        }

        if (money > 10 && money < 500){
            Text.request(number, money);
        } else {
            Text.incorrect();
        }
        
    }
}
