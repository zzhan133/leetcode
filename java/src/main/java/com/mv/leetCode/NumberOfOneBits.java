package com.mv.leetCode;

public class NumberOfOneBits {
    public int hammingWeight(int n) {
        int ans = 0;
        int bitmask = 0x80000000;
        int tmp = bitmask & n;
        if(tmp != 0) ans++;
        n = n & Integer.MAX_VALUE;
        while(n != 0) {
            if(n % 2 == 1) ans++;
            n = n / 2;
        }
        return ans;
    }

}
