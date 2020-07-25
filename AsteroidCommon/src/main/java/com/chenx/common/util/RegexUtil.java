package com.chenx.common.util;

public class RegexUtil {

    public static boolean matchStrings(String regx, String str) {
        String[] regs = regx.split(";");
        for (String reg : regs) {
            if (matchString(reg, str)) {
                return true;
            }
        }

        return false;
    }

    public static boolean matchString(String pattern, String str) {
        int pLen = pattern.length();
        int sLen = str.length();
        int[][] pTable = new int[pLen+1][sLen+1];
        if (pattern.charAt(0) == '*') {
            for (int i = 0; i <= sLen; i++) {
                pTable[0][i] = 1;
            }
            pTable[1][0] = 1;
        }
        pTable[0][0] = 1;

        for (int i = 1; i <= pLen; i++) {
            for (int j = 1; j <= sLen; j++) {
                if (pattern.charAt(i-1) == '?' || pattern.charAt(i-1) == str.charAt(j-1)) {
                    pTable[i][j] = pTable[i-1][j-1];
                } else if (pattern.charAt(i-1) == '*') {
                    if (pTable[i-1][j-1] == 1 || pTable[i-1][j] == 1 || pTable[i][j-1] == 1)
                        pTable[i][j] =  1;
                }
            }
        }

        if (pTable[pLen][sLen] == 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "/swagger-resources/configuration/ui";
        String regx = "*/swagger-resources/*";

        matchString(regx, str);
    }
}
