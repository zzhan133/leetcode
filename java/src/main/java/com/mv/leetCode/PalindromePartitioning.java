package com.mv.leetCode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        if(s == null || s.length() == 0) return ans;
        List<String> path = new ArrayList<>();
        dfs(s, 0, ans, path);
        return ans;
    }
    
    private void dfs(String s, int pos, List<List<String>> ans, List<String> path) {
        if(pos == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        
        for(int end = pos; end < s.length(); end++) {
            if(isPalindrome(s, pos, end)) {
                path.add(s.substring(pos, end + 1));
                dfs(s, end + 1, ans, path);
                path.remove(path.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome (String s, int left, int right) {
        while(left < right) {
                if (s.charAt(right) == s.charAt(left)) {
                    right--;
                    left++;
                } else {
                    return false;
                }
                
            }
        return true;
    }
    
}
