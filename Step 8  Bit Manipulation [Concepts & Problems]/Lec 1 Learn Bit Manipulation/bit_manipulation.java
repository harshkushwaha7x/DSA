// Bit Manipulation

class Solution {
    static void bitManipulation(int num, int i) {
        int get=(num&(1<<i-1))!=0?1:0;
        int set=num|(1<<i-1);
        int clear=num&~(1<<i-1);
        System.out.print(get+" "+set+" "+clear);
    }
}

// K-th Bit is Set or Not

class CheckBit {
    static boolean checkKthBit(int n, int k) {
        StringBuilder str=new StringBuilder();
        while(n!=1){
            str.append(n%2);
            n=n/2;
        }
        for(int i=0;i<str.length();i++){
            if(i==k){
                if(str.charAt(i)=='1'){
                    return true;
                }
            }
        }
        return false;
    }
}

// Odd or Even

class Solution {
    static boolean isEven(int n) {
          
          if((n&1)==0){
              return true;
          }
          
          return false;
    }
}

// Power of Two

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==0){
            return false;
        }
        while(n%2==0){
            n/=2;
        }
        if(n==1){
            return true;
        }
        else{
            return false;
        }
    }
}

// Count total set bits

class Solution{ 
    private static int findx(int n){
        int x=0;
        while((1<<x)<=n)x++;
        return x-1;
    }
    public static int countSetBits(int n){
        if(n==0)return 0;
        int x=findx(n);
        int bitstill2x=x*(1<<(x-1));
        int msb=n-(1<<x)+1;
        int rest=n-(1<<x);
        int ans=bitstill2x+msb+countSetBits(rest);
        return ans;
    }
}

// Divide Two Integers

class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==-2147483648 && divisor ==-1) return Integer.MAX_VALUE;
       BigInteger divden = new BigInteger(Integer.toString(dividend));
       BigInteger divsor = new BigInteger(Integer.toString(divisor));
       BigInteger ans = divden.divide(divsor);
       int res = ans.intValue();
       return res;
    }
}

// Swap two numbers

class Solution{
    static List<Integer> get(int a,int b)
    {
        List<Integer> res=new ArrayList<>();
        a=a^b;
        b=a^b;
        a=a^b;
        res.add(a);
        res.add(b);
        return res;
    }
}

// Set the rightmost unset bit

class Solution {
    static int setBit(int n) {
        return (n | (n + 1));
    }
}