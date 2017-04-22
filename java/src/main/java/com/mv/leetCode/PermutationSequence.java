package com.mv.leetCode;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
    	if(n == 1) return (new Integer(n)).toString();
    	int totleNum = getMultiply(n);
    	if(k > totleNum) return "";
    	char[] sequence = new char[n];
    	for (int i = 0; i < sequence.length; i++) {
			sequence[i] = (char) (i + '1');
		}
    	int distance = 1;
    	while(distance < n) {
    		int currNum = getMultiply(n - distance);
    		int divide = (k - 1) / currNum;
    		char tmp = sequence[distance-1];
    		sequence[distance-1] = sequence[distance - 1 + divide]; //target position
    		sequence[distance - 1 + divide] = tmp;
    		int pos = distance - 1 + divide;
    		while(pos >= distance + 1) {
    			if(sequence[pos] < sequence[pos - 1]) {
    				char swap = sequence[pos - 1];
    				sequence[pos-1] = sequence[pos];
    				sequence[pos] = swap;
    			}
    			pos--;
    		}
    		k = k % currNum == 0 ? currNum : k % currNum;
    		distance++;
    	}
    	return new String(sequence);
    }
    
    private int getMultiply(int n) {
    	int ans = 1;
    	while(n > 1) {
    		ans *= n;
    		n--;
    	}
    	return ans;
    }

}
