package com.b.simple.design.business.text;

public class TextHelper {

    public String swapLastTwoCharacters(String str) {
        final int strLength = str.length();
        if (strLength < 2) {
            return str;
        }

        char lastChar = str.charAt(strLength - 1);
        char secondLastChar = str.charAt(strLength - 2);
        String restOfTheString = str.substring(0, strLength - 2);
        return restOfTheString + lastChar + secondLastChar;
    }

    public String truncateAInFirst2Positions(String str) {
        final int strLength = str.length();
        if (strLength < 2) {
            return str.replace("A", "");
        }
        String firstTwoCharacters = str.substring(0,2);
        String firstTwoCharactersTruncated = firstTwoCharacters.replace("A", "");
        String restOfTheString = str.substring(2);
        return firstTwoCharactersTruncated + restOfTheString;
    }
}
