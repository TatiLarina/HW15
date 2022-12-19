package ru.netology.aviatickets;

public class NegativeIdException extends RuntimeException {

    public NegativeIdException(String msg) {
        super(msg);
    }
}
