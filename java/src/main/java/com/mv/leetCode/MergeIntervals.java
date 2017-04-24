package com.mv.leetCode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {

	public List<Interval> merge(List<Interval> intervals) {
		LinkedList<Interval> ans = new LinkedList<>();
		if(intervals == null || intervals.isEmpty()) {
			return ans;
		}
		Comparator<Interval> comparator = (a, b) -> a.start - b.start;
		intervals.sort(comparator);
		ans.add(intervals.get(0));
		for (int i = 1; i < intervals.size(); i++) {
			Interval lastItem = ans.get(ans.size() - 1);
			if(lastItem.end >= intervals.get(i).start) {
				int newEnd = Math.max(lastItem.end, intervals.get(i).end);
				Interval combimedItem = new Interval(lastItem.start, newEnd);
				ans.removeLast();
				ans.add(combimedItem);
			} else {
				ans.add(intervals.get(i));
			}
		}
		return ans;
	}
}
