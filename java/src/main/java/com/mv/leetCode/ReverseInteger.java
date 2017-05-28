package com.mv.leetCode;

public class ReverseInteger {
    public int reverse(int x) {
        boolean flag = x >= 0 ? true : false;
        long ansLong = helper((Math.abs((long)x)));
        if(flag && ansLong > 2147483647) {
            return 0;
        } else if(!flag && ansLong > 2147483648l) {
            return 0;
        } else {
            int ans = (int) ansLong;
            return flag ? ans : 0-ans;
        }
    }
    
    private long helper(long x) {
        String numberAsString = Long.toString(x);
        StringBuilder sb = new StringBuilder(numberAsString);
        int low = 0;
        int high = sb.length() - 1;
        while(low < high) {
            char tmp = sb.charAt(low);
            sb.setCharAt(low, sb.charAt(high));
            sb.setCharAt(high, tmp);
            low++;
            high--;
        }
        
        return Long.parseLong(sb.toString());
    }
}
