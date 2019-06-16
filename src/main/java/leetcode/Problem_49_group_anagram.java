package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Problem_49_group_anagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Long, List<String>> hashed = new HashMap<Long, List<String>>();
        for(String x : strs) {
            Long enc = encrypt(x);
            List<String> grp = null;
            if(hashed.containsKey(enc)) {
                grp = hashed.get(enc);
            } else {
                grp = new ArrayList<String>();
            }
            grp.add(x);
            hashed.put(enc, grp);
        }
        return new ArrayList<List<String>>(hashed.values());
    }

    public Long encrypt(String x) {
        Long enc = 0L;
        for(char c : x.toCharArray()) {
            enc += c * c * c * c;
        }
        return enc;
    }
}