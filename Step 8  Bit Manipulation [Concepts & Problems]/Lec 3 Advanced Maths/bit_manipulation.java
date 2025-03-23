// Prime Factors

import java.util.ArrayList;
import java.util.List;

class Solution
{
    public int[] AllPrimeFactors(int n)
    {
        int i=2;
        List<Integer>list=new ArrayList<>();
        while(n!=1){
            if(n%i==0){
                n=n/i;
                if(!list.contains(i)) list.add(i);
            }else{
                i++;
            }
        }
        int res[]=new int[list.size()];
        for(int j=0;j<list.size();j++){
            res[j]=list.get(j);
        }
        return res;
    }
}

// All divisors of a Number

class Solution {
    public static void print_divisors(int n) {
        for(int i=1;i<Math.sqrt(n);i++){
            if(n%i==0)System.out.print(i+" ");
        }
         for(int i=(int)(Math.sqrt(n)+0.99);i<=n;i++){
            if(n%i==0)System.out.print(i+" ");
        }
    }
}

// Count Primes

public class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        
        return count;
    }
}

// Prime Factorization using Sieve

class Solution {
    static void sieve() {}

    static List<Integer> findPrimeFactors(int N) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i<=Math.sqrt(N); i++) {
            if (N % i == 0){
                while(N % i == 0){
                    list.add(i);
                    N/=i;
                }
            }
        }
        if (N != 0 && N != 1)
        list.add(N);
        
        return list;
        
    }
}

// Pow(x, n)

class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        long power = n;
        if (n < 0) {
            x = 1 / x;
            power = -power;
        }
        double result = 1;
        while (power > 0) {
            if (power % 2 == 1) result *= x;
            x *= x;
            power /= 2;
        }
        return result;
    }
}
