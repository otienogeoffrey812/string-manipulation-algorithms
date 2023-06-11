package org.example;

import java.util.Arrays;
import java.util.HashMap;
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

    public boolean areRotations(String first, String second){
        if (first == null || second == null)
            return false;

        return first.length() == second.length()
                && (first+first).contains(second);
    }

    public String removeDuplicates(String str){
        if (str == null || str.isEmpty())
            return "";

        HashSet<Character> hashSet = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            var current = str.charAt(i);
            if (!hashSet.contains(current)){
                stringBuilder.append(current);
                hashSet.add(current);
            }
        }
        return stringBuilder.toString();
    }

    public char mostRepeatedCharacter(String str){

        HashMap<Character, Integer> hashMap = new HashMap<>();
        int count = 0;
        char mostRepeatedChar = ' ';

        for (int i = 0; i < str.length(); i++) {
            var current = str.charAt(i);
            if (hashMap.get(current) != null){
                hashMap.replace(current, hashMap.get(current) + 1);
            }else {
                hashMap.put(current, 1);
            }
            if (hashMap.get(current) > count){
                count = hashMap.get(current);
                mostRepeatedChar = current;
            }
        }
        return  mostRepeatedChar;
    }

    public String capitalizeAndRemoveExtraSpaces(String str){
        if (str == null || str.trim().isEmpty())
            return "";

        String[] wordsArray = str.replaceAll(" +", " ").trim().split(" ");
        StringBuilder stringBuilder = new StringBuilder();

        for (String word: wordsArray){
            var capWord = word.substring(0, 1).toUpperCase() + word.substring(1);
            stringBuilder.append(capWord).append(" ");
        }

        return stringBuilder.toString().trim();
    }

    public boolean isAnagram(String first, String second){
        if (first == null || second == null)
            return false;

        var firstArray = first.toCharArray();
        Arrays.sort(firstArray);

        var secondArray = second.toCharArray();
        Arrays.sort(secondArray);

        return Arrays.equals(firstArray, secondArray);
    }

    public boolean isPalindrome(String str){
        if (str == null)
            return false;

        int left = 0;
        int right = str.length() - 1;

        while (left < right){
            if (str.charAt(left++) != str.charAt(right--))
                return false;
        }
        return true;
    }
    public String longestPalindromeSubstring(String str){
        if (str == null || str.length() < 1) return "";
        int start = 0;
        int end = 0;

        for (int i = 0; i < str.length(); i++) {
            int length1 = expandFromMiddle(str, i, i);
            int length2 = expandFromMiddle(str, i, i+1);
            int length = Math.max(length1, length2);

            if (length > end - start){
                start = i - ((length -1) / 2);
                end = i + (length / 2);
            }
        }
        return str.substring(start, end + 1);
    }

    private int expandFromMiddle(String s, int left, int right){
        if (s == null || left > right) return 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
}
