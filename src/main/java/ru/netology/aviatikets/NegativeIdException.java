package ru.netology.aviatikets;

public class NegativeIdException extends RuntimeException {

    public NegativeIdException(String msg) {
        super(msg);
    }
}
