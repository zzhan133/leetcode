package com.mv.leetCode;
import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class InsertIntervalTest {

	@Test
	public void testInsert() throws Exception {
		InsertInterval obj = new InsertInterval();
		List<Interval> intervals = new LinkedList<>();
		Interval a = new Interval(5, 7);
		intervals.add(a);
		Interval newInterval = new Interval(1,2);
		List<Interval> ans = obj.insert(intervals, newInterval);
		assertEquals(2, ans.size());
	}
	
	@Test
	public void testInsert2() throws Exception {
		InsertInterval obj = new InsertInterval();
		List<Interval> intervals = new LinkedList<>();
		Interval a = new Interval(2, 5);
		intervals.add(a);
		Interval newInterval = new Interval(1,6);
		List<Interval> ans = obj.insert(intervals, newInterval);
		assertEquals(1, ans.size());
	}
	
	@Test
	public void testInsert3() throws Exception {
		InsertInterval obj = new InsertInterval();
		List<Interval> intervals = new LinkedList<>();
		Interval a = new Interval(1, 5);
		intervals.add(a);
		Interval newInterval = new Interval(2,6);
		List<Interval> ans = obj.insert(intervals, newInterval);
		assertEquals(1, ans.size());
	}

}
