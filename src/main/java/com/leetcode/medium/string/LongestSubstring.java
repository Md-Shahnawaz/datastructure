package com.leetcode.medium.string;

import java.util.HashSet;
import java.util.Set;

//Rabin - Karp Algorithm
public class LongestSubstring {

    public static void main(String[] args) {
        System.out.println(longestDupSubstring("bcddgefgebcaa"));
        System.out.println(longestDupSubstring("moplvidmaagmsiyyrkchbyhivlqwqsjcgtumqscmxrxrvwsnjjvygrelcbjgbpounhuyealllginkitfaiviraqcycjmskrozcdqylbuejrgfnquercvghppljmojfvylcxakyjxnampmakyjbqgwbyokaybcuklkaqzawageypfqhhasetugatdaxpvtevrigynxbqodiyioapgxqkndujeranxgebnpgsukybyowbxhgpkwjfdywfkpufcxzzqiuglkakibbkobonunnzwbjktykebfcbobxdflnyzngheatpcvnhdwkkhnlwnjdnrmjaevqopvinnzgacjkbhvsdsvuuwwhwesgtdzuctshytyfugdqswvxisyxcxoihfgzxnidnfadphwumtgdfmhjkaryjxvfquucltmuoosamjwqqzeleaiplwcbbxjxxvgsnonoivbnmiwbnijkzgoenohqncjqnckxbhpvreasdyvffrolobxzrmrbvwkpdbfvbwwyibydhndmpvqyfmqjwosclwxhgxmwjiksjvsnwupraojuatksjfqkvvfroqxsraskbdbgtppjrnzpfzabmcczlwynwomebvrihxugvjmtrkzdwuafozjcfqacenabmmxzcueyqwvbtslhjeiopgbrbvfbnpmvlnyexopoahgmwplwxnxqzhucdieyvbgtkfmdeocamzenecqlbhqmdfrvpsqyxvkkyfrbyolzvcpcbkdprttijkzcrgciidavsmrczbollxbkytqjwbiupvsorvkorfriajdtsowenhpmdtvamkoqacwwlkqfdzorjtepwlemunyrghwlvjgaxbzawmikfhtaniwviqiaeinbsqidetfsdbgsydkxgwoqyztaqmyeefaihmgrbxzyheoegawthcsyyrpyvnhysynoaikwtvmwathsomddhltxpeuxettpbeftmmyrqclnzwljlpxazrzzdosemwmthcvgwtxtinffopqxbufjwsvhqamxpydcnpekqhsovvqugqhbgweaiheeicmkdtxltkalexbeftuxvwnxmqqjeyourvbdfikqnzdipmmmiltjapovlhkpunxljeutwhenrxyfeufmzipqvergdkwptkilwzdxlydxbjoxjzxwcfmznfqgoaemrrxuwpfkftwejubxkgjlizljoynvidqwxnvhngqakmmehtvykbjwrrrjvwnrteeoxmtygiiygynedvfzwkvmffghuduspyyrnftyvsvjstfohwwyxhmlfmwguxxzgwdzwlnnltpjvnzswhmbzgdwzhvbgkiddhirgljbflgvyksxgnsvztcywpvutqryzdeerlildbzmtsgnebvsjetdnfgikrbsktbrdamfccvcptfaaklmcaqmglneebpdxkvcwwpndrjqnpqgbgihsfeotgggkdbvcdwfjanvafvxsvvhzyncwlmqqsmledzfnxxfyvcmhtjreykqlrfiqlsqzraqgtmocijejneeezqxbtomkwugapwesrinfiaxwxradnuvbyssqkznwwpsbgatlsxfhpcidfgzrc"));
    }

//    public static String longestDupSubstring(String S) {
//        int lo = 1;
//        int hi = S.length();
//        while (lo != hi) {
//            int mi = lo + (hi - lo) / 2;
//            if (possible(S, mi) != -1)
//                lo = mi + 1;
//            else
//                hi = mi;
//        }
//        int start = possible(S, lo - 1);
//        return start != -1 ? S.substring(start, start + lo - 1) : "";
//    }

    public static String longestDupSubstring(String s) {
        int l = 0, r = s.length() - 1;
        while(l < r){
            int mid = (r - l)/2 + l;
            if(possible(s, mid) != -1) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        int index = possible(s, l - 1);
        return index != -1 ? s.substring(index + 1, index + l) : "";
    }

    private static int possible(String s, int len){
        long mod = Integer.MAX_VALUE;
        int f = 255;
        long hash = 0;
        for (int i = 0; i < len; i++) {
            hash = (hash * f + s.charAt(i)) % mod;
        }
        long absPower = 1;
        for (int i = 0; i < len; i++) {
            absPower = (absPower * f) % mod;
        }
        Set<Long> set = new HashSet<>();
        set.add(hash);
        for (int i = 0; i < (s.length() - len); i++) {
            hash = (hash * f - ((s.charAt(i) * absPower) % mod));
            hash = (hash + s.charAt(i + len)) % mod;
            if (set.contains(hash)) return i;
            set.add(hash);
        }
        return -1;
    }

//    public static int possible(String s, int len) {
//        long hash = 0;
//        int a = 26;
//        int n = s.length();
//        final long mod = (long)Math.pow(2, 32);
//        for(int i = 0; i < len; ++i)
//            hash = (hash * a + (s.charAt(i)-'a')) % mod;
//
//        HashSet<Long> set = new HashSet();
//        set.add(hash);
//        long global = 1;
//        for (int i = 0; i < len; ++i)
//            global = (global * a) % mod;
//
//        for(int start = 1; start < n - len + 1; ++start) {
//            hash = (hash * a - (s.charAt(start - 1)-'a') * global % mod + mod) % mod;
//            hash = (hash + (s.charAt(start + len - 1)-'a')) % mod;
//            if (set.contains(hash)) return start;
//            set.add(hash);
//        }
//        return -1;
//    }
}
