package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary)
  [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
          [4,          9]
 This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 Solution: O(n): Iterate through each interval and check for each overlapping case
 */
public class InsertInterval {

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        Interval i1 = new Interval(1, 2);
        Interval i2 = new Interval(3, 5);
        Interval i3 = new Interval(6, 7);
        Interval i4 = new Interval(8, 10);
        Interval i5 = new Interval(12, 16);
        List<Interval> list = Arrays.asList(i1, i2, i3, i4, i5);
        List<Interval> result = new InsertInterval().insert(list, new Interval(4, 9));
        result.stream().map(x -> x.start + " " + x.end).forEach(System.out::println);
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null) return intervals;
        List<Interval> res = new ArrayList<>();
        int i = 0;
        //[1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
         //       [4,          9]
        //无交集时直接加入到新的集合
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            res.add(intervals.get(i++));
        }
        //有交集时取首尾的节点
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        res.add(newInterval);
        while (i < intervals.size()) {
            res.add(intervals.get(i++));
        }
        return res;
    }
}
