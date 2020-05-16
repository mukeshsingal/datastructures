package CodingNinja.NumberTheory1;

public class GCD {
    public static void main(String[] args) {
        System.out.println(gcd(10, 5));
        System.out.println(gcd(10, 3));
        System.out.println(gcd(10, 6));
    }
    
    private static int gcd(int a, int b) {
        if(b == 0) return a;

        if(a > b) {
            return gcd(b, a % b);
        }
        else {
            return gcd(a, b % a);
        }
    }
}