package com.testxx.util;

public class StringUtils {

    /**
     * 普通判断字符串是否为空的方法
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        return "".equals(str) || str == null;
    }

    public static void main(String[] args) {
        System.out.println(StringUtils.isEmpty(""));
    }
}
