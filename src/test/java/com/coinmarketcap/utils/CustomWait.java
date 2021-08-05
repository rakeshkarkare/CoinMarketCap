package com.coinmarketcap.utils;

public class CustomWait {
    /**
     * Set sleep wait
     * @param seconds
     */
    public static void sleep(int seconds){

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
        }
    }

}
