package com.mv.leetCode;

import java.util.PriorityQueue;

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
	
	public int[] getMaxProfit(int[] prices) {
		int N = prices.length;
		int[] ans = new int[N];
		ans[0] = 0;
		int minPos = 0;
		for (int i = 1; i < N; i++) {
			if(prices[i] < prices[minPos]) {
				ans[i] = ans[i-1];
			} else{
				ans[i] = Math.max(ans[i-1], prices[i] - prices[minPos]);
			}
		}
		return ans;
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

		int ans = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		int minPos = getNextMinPos(prices, 0);
		while(minPos < prices.length - 1) {
			int maxPos = minPos + 1;
			maxPos = getNextMaxPos(prices, minPos + 1);
			int gap = prices[maxPos] - prices[minPos];
			queue.add(gap);
			if (queue.size() > 2)
				queue.poll();
			if(maxPos == prices.length - 1) break;
			minPos = getNextMinPos(prices, maxPos + 1);
		}

		while (!queue.isEmpty())
			ans += queue.poll();
		return ans;
	}

}
