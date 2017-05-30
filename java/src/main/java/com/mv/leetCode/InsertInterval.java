package com.mv.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InsertInterval {
	
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ans = new LinkedList<>();
        int walker = 0;
        int newStart = -1;
        while (walker < intervals.size()) {
            if (intervals.get(walker).end < newInterval.start) {
                ans.add(intervals.get(walker));
                walker++;
            } else {
                newStart = newStart == -1 ?  Math.min(intervals.get(walker).start, newInterval.start) : newStart;
                while (walker < intervals.size()) {
                    Interval item = intervals.get(walker);
                    if(newInterval.end < item.start) {
                        ans.add(new Interval(newStart, newInterval.end));
                        break;
                    } else if (newInterval.end <= item.end) {
                        ans.add(new Interval(newStart, item.end));
                        walker++;
                        break;
                    } else {
                        walker++;
                    }
                }
            }
        }
        if(ans.isEmpty() || newInterval.start > ans.get(ans.size() - 1).end) {
            ans.add(newInterval);
        }
        return ans;
    }
    
    public List<Interval> insert1(List<Interval> intervals, Interval newInterval) {
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
