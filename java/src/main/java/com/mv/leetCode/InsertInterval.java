package com.mv.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	List<Interval> ans = new LinkedList<Interval>();
    	if(intervals.isEmpty()) {
    		ans.add(newInterval);
    		return ans;
    	}
    	for (int i = 0; i < intervals.size(); i++) {
    		Interval curr = intervals.get(i);
			if(newInterval.end < curr.start) {
				ans.add(newInterval);
				ans.addAll(new ArrayList<>(intervals.subList(i, intervals.size())));
				break;
			} else if(newInterval.start > curr.end) {
				ans.add(curr);
			} else { //overlap
				int newStart = Math.min(newInterval.start, curr.start);
				int nextPos = i+1;
				Interval nextInterval = intervals.get(nextPos);
				while(nextPos < intervals.size()) {
					if(newInterval.end < nextInterval.start) {
						int newEnd = Math.max(newInterval.end, intervals.get(nextPos - 1).end);
						ans.add(new Interval(newStart,  newEnd));
						ans.addAll(new ArrayList<>(intervals.subList(nextPos, intervals.size())));
						return ans;
					} else {
						nextPos++;
						nextInterval = intervals.get(nextPos);
					}
				}
				if(nextPos == intervals.size() - 1) {
					int newEnd = Math.max(newInterval.end, intervals.get(nextPos).end);
					ans.add(new Interval(newStart,  newEnd));
					return ans;
				}
			}
		}
    	if(newInterval.start > ans.get(ans.size() - 1).end) {
    		ans.add(newInterval);
    	}
    	return ans;
    }

}
