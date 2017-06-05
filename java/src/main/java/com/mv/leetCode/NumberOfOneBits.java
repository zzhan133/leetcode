package com.mv.leetCode;

public class NumberOfOneBits {
    public int hammingWeight(int n) {
        int ans = 0;
        int bitsmask = 0x80000000;
        if((n & bitsmask) != 0) ans++;
        int val = n & Integer.MAX_VALUE;
        while(val != 0) {
            if(val % 2 ==  1)
                ans++;
            val = val / 2;
        }
        return ans;
    }
    public int hammingWeight1(int n) {
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
