package com.api.carinapi.statements.GlobalFile;

import java.util.Random;

public class RandomVariable extends Variable{
    static Random rd;

    public RandomVariable() {
       rd=getInstance();
       identifier="random";
    }
    public static Random getInstance(){
        if(rd==null){
            return new Random();
        }
        return rd;
    }
    public int evaluate() {
        return rd.nextInt(0,99);
    }

    public void assignValue(int value){
        return;
    }

}