package com.mv.leetCode;

public class FibonacciNumbers {
	public int fib(int n) {
		if(n < 1) {
			throw new IllegalArgumentException();
		}
		if(n == 1 || n == 2) {
			return 1;
		}
		
		return fib(n - 1) + fib(n-2);
	}
	
	public int fibDP(int n) {
		if(n < 1) {
			throw new IllegalArgumentException();
		}
		if(n == 1 || n == 2) {
			return 1;
		}
		int v1 = 1; //smaller one
		int v2 = 1;
		int index = 3;
		int curr = 0;
		while(index < n){
			curr = v1 + v2;
			v1 = v2;
			v2 = curr;
			index++;
		}
		return v1 + v2;
	}

}
