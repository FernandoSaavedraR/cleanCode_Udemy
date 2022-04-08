package com.d.tdd;

public class StringHelper {

    public String replaceAInFirst2Positions(String str) {
        if (str.length() < 2) {
            return replaceAinString(str);
        }
        String firstTwoChars = str.substring(0, 2);
        String restOfTheString = str.substring(2);
        return replaceAinString(firstTwoChars) + restOfTheString;

    }

    private static String replaceAinString(String str) {
        return str.replaceAll("A", "");
    }

    boolean areFirstTwoAndLastTwoCharsTheSame(String str) {
        if (str.length() < 2) {
            return false;
        }
        String firstTwoChars = str.substring(0, 2);
        String lastTwoChars = str.substring(str.length() - 2);

        return firstTwoChars.equals(lastTwoChars) ;
    }

}
