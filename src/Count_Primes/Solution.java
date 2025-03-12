package Count_Primes;

import java.util.Arrays;

public class Solution {
    public static int countPrimes(int n){
        if(n < 2) return 0;

        boolean isPrime[] = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for(int i = 2; i*i < n; i++){
            if(isPrime[i]){
                for(int j = i*i; j < n; j+=i){
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for(boolean prime : isPrime){
            if(prime) count++;
        }
        return count;
    }
    public static void main(String[] args) {
        int n = 10;
        System.out.print("The total numbers of prime numbers are : " + countPrimes(n));
    }
}
