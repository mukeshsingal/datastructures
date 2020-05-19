package CodingNinja.ModuloArithmetic;

public class NumberOfBalancedBinaryTree {
    static final int mod = (int)Math.pow(10, 9) + 7;

    public static void main(String[] args) {
        System.out.println(balancedBinaryTree(7));
        
    }
 
    static int balancedBinaryTree(int height) {
        if(height == 0|| height==1) {
            return 1;
        }
        int x = balancedBinaryTree(height-1);
        int y = balancedBinaryTree(height-2); 

        long xResult = (long)(x*x);
        long yResult = (long)(2*x*y);

        return ((int)(xResult%mod) +(int)(yResult%mod))%mod;
    }
}