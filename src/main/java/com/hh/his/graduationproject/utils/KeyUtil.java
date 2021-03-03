package com.hh.his.graduationproject.utils;


public class KeyUtil {



    private static byte[] lock = new byte[0];

    // 位数，默认是5位
    private final static long w = 100000;

    public static String createID() {
        long r = 0;
        synchronized (lock) {
            r = (long) ((Math.random() + 1) * w);
        }

        return String.valueOf(System.currentTimeMillis()).substring(0,5) + String.valueOf(r).substring(1);
    }

}
