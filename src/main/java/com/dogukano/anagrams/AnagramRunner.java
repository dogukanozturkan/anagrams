package com.dogukano.anagrams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class AnagramRunner {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();

        System.out.println("# 1st Method: Basic Anagram Checker");
        System.out.println( (isAnagram(a, b)) ? "Anagrams" : "Not Anagrams" );

        System.out.println("# 2nd Method: Char Array Anagram Checker");
        System.out.println( (isAnagramWithChar(a, b)) ? "Anagrams" : "Not Anagrams" );

        System.out.println("# 3rd Method: HashMap Anagram Checker Solution");
        System.out.println( (isAnagramWithHashMap(a, b)) ? "Anagrams" : "Not Anagrams" );
    }

    static boolean isAnagramWithHashMap(String a, String b) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c: a.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c: b.toCharArray()) {
            int count = map.getOrDefault(c, 0);
            if (count == 0) {
                return false;
            } else {
                map.put(c, count - 1);
            }
        }
        return true;
    }

    static boolean isAnagramWithChar(String a, String b) {
        if (a.length() != b.length()) return false;

        a = a.toLowerCase();
        b = b.toLowerCase();

        char[] c1 = a.toCharArray();
        char[] c2 = b.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        String sc1 = new String(c1);
        String sc2 = new String(c2);

        return sc1.equals(sc2);
    }

    static boolean isAnagram(String a, String b) {
        String first = a
                .replaceAll("\\s", "")
                .toLowerCase();

        String second = b
                .replaceAll("\\s", "")
                .toLowerCase();

        int aLength = first.length();
        int bLength = second.length();

        if (aLength != bLength) return false;

        int[] charFrequencies = new int[26];

        for (int i = 0; i < aLength; i++) {
            char currentChar = first.charAt(i);
            int index = currentChar - 'a';
            charFrequencies[index]++;
        }

        for (int i = 0; i < bLength; i++) {
            char currentChar = second.charAt(i);
            int index = currentChar - 'a';
            charFrequencies[index]--;
        }

        for (int i = 1; i < 26; i++) {
            if (charFrequencies[i] != 0) return false;
        }
        return true;
    }
}
