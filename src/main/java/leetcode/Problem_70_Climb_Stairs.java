package leetcode;

public class Problem_70_Climb_Stairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
    public static int climbStairs(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs(0, n, memo);
    }
    public static int climb_Stairs(int i, int n, int memo[]) {
        return 0;
    }
}

// [1 , 1, 1]
// [1]
// [    ]