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
        return (n & 1) == 0 ;
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