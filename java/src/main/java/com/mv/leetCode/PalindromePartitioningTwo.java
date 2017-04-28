package com.mv.leetCode;

public class PalindromePartitioningTwo {
    public int minCut(String s) {
        if(s == null || s.length() == 0) return 0;
        int[] ans = new int[s.length()];
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < isPalindrome.length; i++) {
			isPalindrome[i][i] = true;
		}
        ans[s.length() - 1] = 0;
        for(int i = s.length() - 2; i >= 0; i--)    {
            ans[i] = ans[i+1] + 1;
            for(int j=i+1; j < s.length(); j++) {
                if(s.charAt(j) == s.charAt(i) && (i+1 >= j-1 || isPalindrome[i+1][j-1])){
                	isPalindrome[i][j] = true;
                    if(j == s.length() - 1) {
                        ans[i] = 0;
                        break;
                    } else {
                        ans[i] = Math.min(ans[i], 1 + ans[j+1]);
                    }
                }
            }
        }
        return ans[0];
    }
}
