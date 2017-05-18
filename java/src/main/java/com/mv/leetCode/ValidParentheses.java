package com.mv.leetCode;

import java.util.Stack;

public class ValidParentheses {
	
    public boolean isValid(String s) {
        if(s == null || s.isEmpty()) return true;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if( c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else {
                if(st.isEmpty()) return false;
                char tmp = st.pop();
                if(!((tmp == '(' && c == ')') || (tmp == '{' && c == '}') || (tmp == '[' && c == ']')))
                    return false;
            }
        }
        return st.isEmpty();
    }
}
