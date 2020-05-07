package leetcode;

public class Problem_1002_Find_Common_Characters {
    
}

class Solution {
    public List<String> commonChars(String[] A) {
        int minCache[] = getCache(A[0]);
        for(int i=1;i<A.length;i++) {
           intersection(minCache, getCache(A[i]));
        }
        List<String> list = new ArrayList<>();
        for(int i=0;i<minCache.length;i++) {
            int freq = minCache[i];
            while(freq>0) {
                list.add(String.valueOf((char) (i + 'a')));
                freq--;
            }
        }
        return list;
    }
    
    private int[] getCache(String word) {
        int cache[] = new int[26];
        for(char ch: word.toCharArray()) {
            cache[ch-'a']++;
        }
        return cache;
    }
    
    private void intersection(int[] a, int[] b) {
        for(int i=0; i<a.length; i++) {
            a[i] = Math.min(a[i], b[i]);
        }
    }
}