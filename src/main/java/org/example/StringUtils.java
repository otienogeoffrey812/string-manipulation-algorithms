package org.example;

import java.util.HashSet;

public class StringUtils {
    public String reverseString(String str){
        if (str == null || str.isEmpty())
            return "";

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = str.length() - 1; i >= 0 ; i--) {
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }

    public int countVowels(String str){
        if (str == null || str.isEmpty())
            return 0;

        HashSet<Character> hashSet = new HashSet<>();
        hashSet.add('a');
        hashSet.add('e');
        hashSet.add('i');
        hashSet.add('o');
        hashSet.add('u');

        int count = 0;

        for (Character ch: str.toCharArray()){
            if (hashSet.contains(ch)){
                count++;
            }
        }
        return count;
    }

    public String reverseWords(String str){
        if (str == null || str.isEmpty())
            return "";

        String[] wordsArray = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = wordsArray.length - 1; i >= 0 ; i--) {
            stringBuilder.append(wordsArray[i]).append(" ");
        }

        return stringBuilder.toString().trim();
    }
}
