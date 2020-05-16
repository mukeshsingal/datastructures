package CodingNinja.NumberTheory1;

public class PrimeNumberTillN {
    
    public static void main(String[] args) {
        findPrime(20);
    }
    private static void findPrime(int n) {
        
        for (int i = 1; i <= n; i++) {
            if(checkPrime(i)) {
                System.out.println(i);
            }            
        }
    }
    private static boolean checkPrime(int num) {
        int factorCount = 0;

        for (int i = 1; i * i <= num; i++) {
            if(num % i == 0) {
                factorCount += i*i == num ? 1 : 2;
            }
        }
        return factorCount == 2;
    }
}