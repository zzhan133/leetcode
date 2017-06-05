package com.amazon.leetCode;

public class ReverseBits {
    public int reverseBits(int n) {
        int f = n & 0x0000FFFF;
        int s = (n & 0xFFFF0000) >> 16;
        return (reverse16Bits(f) << 16) + reverse16Bits(s);
    }
    
    private int reverse16Bits(int n) {
        int f = n & 0xFF;
        int s = (n & 0xFF00) >> 8;
        return (reverse8Bits(f) << 8) + reverse8Bits(s);
    }
    
    private int reverse8Bits(int n) {
        int f = n & 0xF;
        int s = (n & 0xF0) >> 4;
        return (reverse4Bits(f) << 4) + reverse4Bits(s);
    }
    
    private int reverse4Bits (int n) {
        int f = n & 0x3;
        int s = (n & 0xc) >> 2;
        return (reverse2Bits(f) << 2) + reverse2Bits(s);
    }
    
    private int reverse2Bits(int n) {
        if(n == 1) return 2;
        if(n == 2) return 1;
        return n;
    }

}
