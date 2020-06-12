package com.hackerrank.string;

public class AlternatingCharacter {

    public static void main(String[] args) {

    }

    static int alternatingCharacters(String s) {

        char[] characters = new char[s.length()];
        s.getChars(0, s.length(), characters, 0);
        char prev = 'c';
        int counter = 0;
        for (int i = 0; i < characters.length; i++) {
            char cur = characters[i];
            if(i != 0 && prev == cur){
                counter ++;
            }
            prev = cur;
        }
        return counter;
    }
}
