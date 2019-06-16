package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Problem_438_find_all_anagram {
    public List<Integer> findAnagrams(String s, String t) {
        int len_s = s.length();
        int len_t = t.length();

        int [] vt = new int[26];
        for(int i = 0;i<len_t;i++){
            vt[t.charAt(i)-'a']++;
        }
        int[] vs = new int[26];

        List<Integer> ret_list = new LinkedList<Integer>();
        for(int i = 0;i<len_s;i++){
            vs[s.charAt(i)-'a']++;

            if(i>=len_t){
                vs[s.charAt(i-len_t)-'a']--;
            }

            if(Arrays.equals(vs,vt)){
                ret_list.add(i-len_t+1);
            }
        }

        return ret_list;
    }
}