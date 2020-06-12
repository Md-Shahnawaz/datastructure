package com.hackerrank.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Sherlock {
    public static void main(String[] args) {
        System.out.println(isValid("aaaaabc"));
        System.out.println(isValid("ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd"));
        System.out.println(isValid("abcdefghhgfedecba"));
    }

    static String isValid(String s) {

        List<String> charsLs = Arrays.asList(s.split(""));
        HashMap<String, Integer> uniq = new HashMap<>();
        for (int i = 0; i < charsLs.size(); i++) {
            uniq.putIfAbsent(charsLs.get(i), 0);
            uniq.computeIfPresent(charsLs.get(i), (k, v) -> v + 1);
        }

        long counter = uniq.size();
        int j = 2;
        while (charsLs.size() >= counter) {
            if (counter == charsLs.size() || (counter + 1) == charsLs.size()) {
                return "YES";
            }
            counter = uniq.size() * j;
            j++;
        }

        return "NO";
    }

}
