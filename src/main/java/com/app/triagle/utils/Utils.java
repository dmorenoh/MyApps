package com.app.triagle.utils;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dmorenoh on 19/3/16.
 */
public class Utils {
    public boolean compareEquals(String str1, String str2) {
        char[] arrChar1 = str1.toCharArray();
        char[] arrChar2 = str2.toCharArray();
        Arrays.sort(arrChar1);
        Arrays.sort(arrChar2);
        return Arrays.equals(arrChar1,arrChar2);
    }

    public boolean checkPalindrome(String str) {
        if (str == null)
            return false;
        StringBuilder aux = new StringBuilder(str);
        String strReversed = aux.reverse().toString();
        return strReversed.equals(str);
    }

    public boolean checkPalindromeLong(String str) {
        if (str==null)
            return false;
        int length = str.length();
        for (int i = 0; i< length /2; i++){
            if(str.charAt(i)!=str.charAt(length - i - 1))
                return false;
        }

        return true;
    }

    public String removeCharacter(String toRemoveChar, char c) {
        if (toRemoveChar==null)
            return null;
        return toRemoveChar.replaceAll(Character.toString(c),"");
    }

    public int getPalindromeWordAmmount(String str) {
        if (StringUtils.isEmpty(str)) {
            return 0;
        }

        Set<String> palindromeSet = new HashSet<String>();

        int length = str.length();
        for (int i = 0; i< length; i++) {
            for (int j=i; j<length; j++) {
                if (this.checkPalindrome(str.substring(i,j))) {
                    palindromeSet.add(str.substring(i,j));
                }
            }
        }
        return palindromeSet.size();
    }

    public String getLargestPalindrome(String str) {
        if(StringUtils.isEmpty(str)) {
            return null;
        }
        String largestPalindrome = str.substring(0, 1);
        int length = str.length();
        for (int i=0;i<length;i++){
            for (int j=i; j<length; j++) {
                String subStr = str.substring(i, j);
                largestPalindrome = updateLargestPalindrome(largestPalindrome, subStr);
            }
        }
        return largestPalindrome;
    }

    private String updateLargestPalindrome(String largestPalindrome, String subStr) {
        if (this.checkPalindrome(subStr)) {
            if (largestPalindrome.length()<subStr.length()){
                largestPalindrome = subStr;
            }
        }
        return largestPalindrome;
    }
}
