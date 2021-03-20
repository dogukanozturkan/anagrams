package com.dogukano.anagrams;

import java.util.Scanner;

public class AnagramRunner {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
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

        int[] char_frequencies = new int[26];

        for (int i = 0; i < aLength; i++) {
            char currentChar = first.charAt(i);
            int index = currentChar - 'a';
            char_frequencies[index]++;
        }

        for (int i = 0; i < bLength; i++) {
            char currentChar = second.charAt(i);
            int index = currentChar - 'a';
            char_frequencies[index]--;
        }

        for (int i = 1; i < 26; i++) {
            if (char_frequencies[i] != 0) return false;
        }
        return true;
    }
}
