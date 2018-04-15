package com.testxx.util;

public class StringUtils {

    public static boolean isEmpty(String str){
        return "".equals(str) || str == null;
    }

    public static void main(String[] args) {
        System.out.println(StringUtils.isEmpty(""));
    }
}
