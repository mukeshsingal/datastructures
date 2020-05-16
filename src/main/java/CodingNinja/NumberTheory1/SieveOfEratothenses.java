package CodingNinja.NumberTheory1;

public class SieveOfEratothenses {
    
    public static void main(String[] args) {
        findPrime(30);
    }

    private static void findPrime(int n) {
        boolean[] sieve = new boolean[n+1];

        sieve[0] = true;
        sieve[1] = true;

        for (int i = 2; i * i < n; i++) {
            if(!sieve[i]) {
                for(int j = i * i; j < n; j+=i) {
                    sieve[j] = true;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if(!sieve[i])
                System.out.println(i);
        }
    }
}
