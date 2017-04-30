package com.mv.leetCode;

public class BestTimeToBuyAndSellStockThree {
	
	private int getNextMinPos(int[] prices, int pos) {
		while(pos < prices.length - 1) {
			if(prices[pos] < prices[pos + 1]) return pos;
			pos++;
		}
		return prices.length - 1;
	}
	
	private int getNextMaxPos(int[] prices, int pos) {
		while(pos < prices.length - 1) {
			if(prices[pos] > prices[pos+1]) return pos;
			pos++;
		}
		return prices.length - 1;
	}
	
	public int getMaxProfit(int[] prices, int begin, int end) {
		int ans = 0;
		int minPos = begin;
		for (int i = begin + 1; i <= end; i++) {
			if(prices[i] < minPos) {
				minPos = i;
			} else {
				ans = Math.max(ans, prices[i] - prices[minPos]);
			}
		}
		return ans;
	}
	
	public int[] getMaxProfit(int[] prices) {
		int N = prices.length;
		int[] ans = new int[N];
		ans[0] = 0;
		int minPos = 0;
		for (int i = 1; i < N; i++) {
			if(prices[i] < prices[minPos]) {
				minPos = i;
				ans[i] = ans[i-1];
			} else{
				ans[i] = Math.max(ans[i-1], prices[i] - prices[minPos]);
			}
		}
		return ans;
	}
	
	
	public int[] getMaxProfitFromEndToBegin(int[] prices) {
		int[] ans = new int[prices.length];
		ans[prices.length - 1] = 0;
		int maxPos = prices.length - 1;
		for (int i = prices.length - 2; i >= 0; i--) {
			if(prices[i] > prices[maxPos]) {
				ans[i] = ans[i+1];
				maxPos = i;
			} else {
				ans[i] = Math.max(prices[maxPos] - prices[i], ans[i+1]);
			}
		}
		return ans;
	}
	
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1)
			return 0;
		
		int[] firstNthProfit = getMaxProfit(prices);
		int[] lastNthProfit = getMaxProfitFromEndToBegin(prices);
		int ans = firstNthProfit[prices.length - 1];
		for (int i = 1; i < lastNthProfit.length - 1; i++) {
			ans = Math.max(ans, firstNthProfit[i] + lastNthProfit[i+1]);
		}
		return ans;
	}

}
