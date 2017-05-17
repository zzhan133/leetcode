package com.mv.leetCode;

/*
 * Simple solution: recursion
 * myPow(x, n) = myPow(x * x, n/2) or myPow(x*x, (n-1)/2) * x;
 * a. Please notice that the termination condition of the recursion; 
 * b. when n == -1 on myPow(x*x, (n-1)/2) * x;
 */

public class Pow {
    public double myPow(double x, int n) {
        if(x == 0 || x == 1 || n == 1) return x;
        if(n == 0) return 1;
        if(n == -1) return 1/x;
        boolean isPositive = true;
        if(x < 0 && n % 2 != 0) isPositive = false;
        if (n < 0) x = 1 / x;
        
        if(n == Integer.MIN_VALUE) {
            x = x * x;
            n = n / 2;
        }
        double ans = helper(x, Math.abs(n));
        return isPositive ? ans : 0 - ans;
    }
    
    private double helper(double x, int n) {
        if(n == 1) return x;
        if (n % 2 == 1) {
            return helper(x * x, n / 2) * x;
        } else {
            return helper(x * x, n / 2);
        }
    }

}
