package leetcode;

import java.util.*;
import java.util.LinkedList;
class Problem_752_Open_the_Lock {
    private static char[] prevChar = new char[] { '9', '0', '1', '2', '3', '4', '5', '6', '7', '8' };
    private static char[] currChar = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    private static char[] nextChar = new char[] { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
    
    public int openLock(String[] deadends, String target) {
        Set<String> death = new HashSet<>();
        for (String d : deadends) death.add(d);
        
        StringBuilder sb = new StringBuilder("0000");
        if (death.contains(sb.toString()) || death.contains(target)) return -1;

        HashMap<String, Integer> visited = new HashMap<>();;
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(sb.toString());
        
        visited.put(sb.toString(), 0);
        
        String next = null, temp = null;
        int order = -1;
        
        while (!queue.isEmpty()) {
            next = queue.poll();
            order = visited.get(next);
            if (next.equals(target)) return order;
            
            sb.setLength(0);
            sb.append(next);
            
            for (int i = 0; i < 4; i++) {
                int idx = sb.charAt(i) - '0';
                
                // next node
                sb.setCharAt(i, nextChar[idx]);
                temp = sb.toString();
                if (!death.contains(temp) && !visited.containsKey(temp)) {
                    queue.offer(temp);
                    visited.put(temp, order + 1);
                }
                
                // prev node
                sb.setCharAt(i, prevChar[idx]);
                temp = sb.toString();
                if (!death.contains(temp) && !visited.containsKey(temp)) {
                    queue.offer(temp);
                    visited.put(temp, order + 1);
                }
                
                // return to the original
                sb.setCharAt(i, currChar[idx]);
            }
        }
        return -1;
    }

}