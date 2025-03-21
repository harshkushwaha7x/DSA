// Bit Manipulation
import java.math.BigInteger;
import java.util.List;
import java.util.ArrayList;

class BitManipulation {
    static void bitManipulation(int num, int i) {
        int get = (num & (1 << (i - 1))) != 0 ? 1 : 0;
        int set = num | (1 << (i - 1));
        int clear = num & ~(1 << (i - 1));
        System.out.print(get + " " + set + " " + clear);
    }
}

// K-th Bit is Set or Not

class CheckKthBit {
    static boolean checkKthBit(int n, int k) {
        StringBuilder str = new StringBuilder();
        while (n != 0) {
            str.append(n % 2);
            n = n / 2;
        }
        if (k < str.length() && str.charAt(k) == '1') {
            return true;
        }
        return false;
    }
}

// Odd or Even

class OddEvenChecker {
    static boolean isEven(int n) {
        return (n & 1) == 0;
    }
}

// Power of Two

class PowerOfTwoChecker {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }
}

// Count total set bits

class CountSetBits {
    private static int findx(int n) {
        int x = 0;
        while ((1 << x) <= n) x++;
        return x - 1;
    }

    public static int countSetBits(int n) {
        if (n == 0) return 0;
        int x = findx(n);
        int bitstill2x = x * (1 << (x - 1));
        int msb = n - (1 << x) + 1;
        int rest = n - (1 << x);
        int ans = bitstill2x + msb + countSetBits(rest);
        return ans;
    }
}

// Divide Two Integers

class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend == -2147483648 && divisor == -1) return Integer.MAX_VALUE;
        BigInteger divden = new BigInteger(Integer.toString(dividend));
        BigInteger divsor = new BigInteger(Integer.toString(divisor));
        BigInteger ans = divden.divide(divsor);
        int res = ans.intValue();
        return res;
    }
}

// Swap two numbers

class SwapNumbers {
    static List<Integer> get(int a, int b) {
        List<Integer> res = new ArrayList<>();
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        res.add(a);
        res.add(b);
        return res;
    }
}

// Set the rightmost unset bit

class SetRightmostUnsetBit {
    static int setBit(int n) {
        return (n | (n + 1));
    }
}