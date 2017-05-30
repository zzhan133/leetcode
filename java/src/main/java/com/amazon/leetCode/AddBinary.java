package com.amazon.leetCode;

public class AddBinary {
	public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int aWalker = a.length() - 1;
        int bWalker = b.length() - 1;
        int adder = 0;
        while (aWalker >= 0 || bWalker >= 0) {
            int adderA = aWalker > -1 ? (a.charAt(aWalker) - '0') : 0;
            int adderB = bWalker > -1 ? (b.charAt(bWalker) - '0') : 0;
            int result = adderA + adderB + adder;
            if(result > 1) {
                result -= 2;
                adder = 1;
            }
            sb.insert(0, result);
            aWalker--;
            bWalker--;
        }
        
        if(adder == 1) sb.insert(0, 1);
        return sb.toString();
        
    }

}
