package com.trainingMug.foodiecli.exceptions;

public class OrderExistException extends Exception{
    public OrderExistException(String message) {
        super(message);
    }
}
