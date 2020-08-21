package leetcode;

public class Problem_1207_Unique_Number_of_Occurrence {

    public boolean uniqueOccurrences(int[] arr) {
        int[] hashmap1 = new int[2001];
        int[] hashmap2 = new int[1001];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i : arr) {
            hashmap1[i + 1000]++;
            if (i + 1000 < min) {
                min = i + 1000;
            }
            
            if (i + 1000 > max) {
                max = i + 1000;
            }
        }
         for (int i = min; i <= max; i++) {
            if(hashmap1[i] != 0) {
                if(hashmap2[hashmap1[i]] == -2) {
                    return false;
                }
                hashmap2[hashmap1[i]] = -2;    
            }
        }
        
        return true;
    }
}