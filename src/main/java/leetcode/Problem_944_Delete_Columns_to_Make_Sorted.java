package leetcode;

public class Problem_944_Delete_Columns_to_Make_Sorted {
}

class Solution {
    private boolean check(String[] A , int col) {
        char prev = ' ';
        for (String string : A) {
            char ch = string.charAt(col);
            if (prev != ' ') {
                if (prev > ch) {
                    return false;
                }
            }
            prev = ch;
        }
        return true;
    }

    public int minDeletionSize(String[] A) {
        int ans = 0;
        int len = A[0].length();

        for (int j = 0; j < len; j++) {
            if (!check(A , j)) {
                ans ++;
            }
        }
        return ans;

    }
}

