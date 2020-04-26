package leetcode;

public class Problem_1217_Play_with_Chips {

}

class Solution {
    public int minCostToMoveChips(int[] chips) {
        int countOdd = 0;
        int countEven = 0;
      
        for (int chip : chips) {
          if (chip % 2 == 0) countEven++;
          else countOdd++;
        }
      
        return Math.min(countOdd, countEven);
    }
}

// class Solution {

//     public int minCostToMoveChips(int[] chips) {
//         HashMap <Integer, Integer> map = new HashMap<>();
        
//         for(int chip : chips) {
//             if(map.containsKey(chip)) {
//                 map.put(chip, map.get(chip)+1);
//             }
//             else {
//                 map.put(chip, 1);
//             } 
//         }
            
//         int globalAns = Integer.MAX_VALUE;

//         for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
//             int gkey = entry.getKey();
            
//             int localAns = 0;
             
//             for (Integer key: map.keySet()) { 
//                 if(gkey != key && (key % 2) != (gkey%2)) {
//                     localAns += map.get(key);
//                 }
//             }
            
//             globalAns = Math.min(globalAns, localAns);
//         }
//         return globalAns;
        
//     }
    
    
    
    
  
// }