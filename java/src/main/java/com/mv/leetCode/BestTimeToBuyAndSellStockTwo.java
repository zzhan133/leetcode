package com.mv.leetCode;

public class BestTimeToBuyAndSellStockTwo {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;

		int ans = 0;
		int lowPos = 0;
		while (lowPos < prices.length - 1) {
			if (prices[lowPos] < prices[lowPos + 1])
				break;
			lowPos++;

		}
		if (lowPos == prices.length - 1)
			return ans;

		int walker = lowPos + 1;
		while (walker < prices.length - 1) {
			if (prices[walker] > prices[walker + 1]) {
				ans += prices[walker] - prices[lowPos];
				lowPos = walker + 1;
				while (lowPos < prices.length - 1) {
					if (prices[lowPos] < prices[lowPos + 1]) {
						walker = lowPos + 1;
						break;
					}
					lowPos++;
				}
				if(lowPos == prices.length - 1) {
					return ans;
				}
			} else
				walker++;
		}

		if (walker == prices.length - 1) {
			ans += prices[walker] - prices[lowPos];
		}
		return ans;
	}

}
