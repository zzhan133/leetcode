package com.mv.leetCode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        if(n < 1) {
            return results;
        }
        func(results, n-1, n, "(");
        return results;
    }
    
    private void func(List<String> results, int lRemaining, int rRemaining, String curr) {
        if(rRemaining == 0){
            results.add(curr);
            return;
        }
        if(lRemaining == 0) {
            func(results, 0, rRemaining - 1, curr+")");
        }
        else {
            func(results, lRemaining - 1, rRemaining, curr+"(");
            if(lRemaining < rRemaining) {
            	func(results, lRemaining, rRemaining - 1, curr+")");
            }
        } 
    } 
}
