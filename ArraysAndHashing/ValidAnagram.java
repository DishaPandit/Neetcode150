package ArraysAndHashing;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {

    //brute force
    //tc - o(nlog n)
    //sc - o(1 or n) dependng on sorting algo used

    public boolean isAnagram(String s, String t) {

        if(s.length()!=t.length())
            return false;

        char s1[] = s.toCharArray();
        Arrays.sort(s1);

        char t1[] = t.toCharArray();
        Arrays.sort(t1);

        return Arrays.equals(s1,t1);

    }



    //optimised - but works only for lowercase a-z
    //tc - o(n)
    //sc - o(1)

    public static boolean isAnagram1(String s, String t) {

        if(s.length()!=t.length())
            return false;

        int count[] = new int[26];
        for(int i=0; i<s.length(); i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
        for(int i:count){
            if(i!=0)
                return false;
        }
        return true;
    }



    //optimised for all unicode character
    //tc - o(n)
    //sc - o(k) , k is no. of unique characters

    public static boolean isAnagram2(String s, String t) {

        if(s.length()!=t.length())
            return false;

        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch,0)+1);
        }
        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            hm.put(ch, hm.getOrDefault(ch,0)-1);
        }

        for(int i : hm.values()){
            if(i!=0)
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "disha";
        String t = "ashid";

        boolean result = isAnagram2(s,t);
        System.out.println("Valid Anagram : " + result);
    }

}
