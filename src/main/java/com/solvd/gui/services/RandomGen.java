package com.solvd.gui.services;

import java.util.*;
import java.util.stream.Collectors;

public class RandomGen {
    public static char generateRandomAlphabeticSymbol() {
        Random rnd = new Random();
        return (char) ('a' + rnd.nextInt('z' - 'a' + 1));
    }

    public static String generateRandomNameOrSurname(int minimLength, int maximumLength) {
        Random rnd = new Random();
        int len = minimLength + 1 + rnd.nextInt(maximumLength - minimLength + 1);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.valueOf(generateRandomAlphabeticSymbol()).toUpperCase());
        for (int i = 1; i < len; i++) {
            stringBuilder.append(generateRandomAlphabeticSymbol());
        }
        return stringBuilder.toString();
    }

    public static char generateRandomDigit() {
        Random rnd = new Random();
        return (char) ('0' + rnd.nextInt(10));
    }

    public static String generateRandomNameOrSurname() {
        return generateRandomNameOrSurname(5, 10);
    }

    private static List<Character> getCharacterListFromString(String s) {
        return s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
    }

    private static char[] getCharArrayFromCharacterList(List<Character> list) {
        char[] array = new char[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    public static String shuffle(String s) {
        List<Character> listChar = getCharacterListFromString(s);

        Collections.shuffle(listChar);
        return new String(getCharArrayFromCharacterList(listChar));
    }

    public static String generateValidPassword() {
        return shuffle(generateRandomNameOrSurname(8, 12) + generateRandomDigit());
    }

    public static String generateEmail() {
        return generateRandomNameOrSurname() + "@gmail.com";
    }
}
