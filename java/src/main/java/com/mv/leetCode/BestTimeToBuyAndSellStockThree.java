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
