package leetcode;

public class Problem_1221_Split_a_String_in_Balanced_Strings {

        public int balancedStringSplit(String s) {
            int count = 0;
            int reset = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'L') {
                    count ++;
                }
                else {
                    count --;
                } if (count == 0) reset++;
            }
            return reset;
        }
}

