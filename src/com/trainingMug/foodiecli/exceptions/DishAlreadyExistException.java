package com.trainingMug.foodiecli.exceptions;

public class DishAlreadyExistException extends Exception{
    public DishAlreadyExistException(String msg){
        super(msg);
    }
}
