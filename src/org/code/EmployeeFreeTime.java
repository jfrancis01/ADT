package org.code;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class EmployeeFreeTime {

	public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
		List<Interval> res = new ArrayList<>();
		PriorityQueue<Interval> pq = new PriorityQueue<>(
				(a, b) -> a.start != b.start ? a.start - b.start : a.end - b.end);

		for (List<Interval> intervals : schedule) {
			for (Interval interval : intervals) {
				pq.offer(interval);
			}
		}
		//print(pq);

		if (pq.isEmpty())
			return res;

		Interval pre = pq.poll();

		while (!pq.isEmpty()) {
			Interval cur = pq.poll();
			if (pre.end < cur.start) {
				res.add(new Interval(pre.end, cur.start));
			} else {
				cur.start = Math.min(pre.start, cur.start);
				cur.end = Math.max(pre.end, cur.end);
			}
			pre = cur;
		}

		return res;
	}
	
	public void print(PriorityQueue<Interval> pq) {
		while(!pq.isEmpty()) {
			Interval interval = pq.poll();
			System.out.print("[" + interval.start + ", " + interval.end + "], ");
		}
	}

	public static void main(String[] args) {
		EmployeeFreeTime eft = new EmployeeFreeTime();
		//[[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
		Interval int1 = new Interval(1,3);
		Interval int2 = new Interval(6,7);
		Interval int3 = new Interval(2,4);
		Interval int4 = new Interval(2,5);
		Interval int5 = new Interval(9,12);
		
		List<Interval> l1 = new ArrayList<Interval>();
		l1.add(int1);
		l1.add(int2);
		List<Interval> l2 = new ArrayList<Interval>();
		l2.add(int3);
		List<Interval> l3 = new ArrayList<Interval>();
		l3.add(int4);
		l3.add(int5);
		List<List<Interval>>schedule = new ArrayList<List<Interval>>();
		schedule.add(l1);
		schedule.add(l2);
		schedule.add(l3);
		
		List<Interval> ans  = eft.employeeFreeTime(schedule);
		for(Interval interval : ans) {
			System.out.print("[" + interval.start + ", " + interval.end + "], ");
		}
		
	}

}