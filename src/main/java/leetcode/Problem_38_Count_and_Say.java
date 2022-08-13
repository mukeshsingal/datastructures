package leetcode;

/**
 * https://leetcode.com/problems/count-and-say/
 */
public class Problem_38_Count_and_Say {
    public String countAndSay(int n) {

        StringBuilder curr = new StringBuilder("1");
        StringBuilder prev;

        for(int i = 1; i < n; i++) {
            prev = curr;
            curr = new StringBuilder();
            int count = 1;
            char say = prev.charAt(0);

            for(int j = 1; j < prev.length(); j++) {
                if(prev.charAt(j) != say) {
                    curr.append(count).append(say);
                    count = 1;
                    say = prev.charAt(j);
                }
                else {
                    count++;
                }
            }
            curr.append(count).append(say);
        }

        return curr.toString();
    }
}
