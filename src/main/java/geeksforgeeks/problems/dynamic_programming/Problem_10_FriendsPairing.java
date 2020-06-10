package geeksforgeeks.problems.dynamic_programming;

public class Problem_10_FriendsPairing {
    public static void main(String[] args) {
        
        System.out.println(pairs(4));
    }

    static int pairs( int n) {
        if(n == 0) {
            return 1;
        }
        if(n < 0) {
            return 0;
        }

        return pairs(n-1) + (n-1)*pairs(n-2);
    }
}