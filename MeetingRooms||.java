/*
Given an array of meeting time intervals consisting of start and end times [[s1, e1], [s2, e2], ...] (si < ei), find the minimum number of 
conference rooms required.
For example,
Given [[0, 30], [5, 10], [15, 20]],
return 2.
*/
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        // Edge cases
        if (intervals == null || intervals.length == 0) return 0;
        
        // Find the earliest starting time
        // Find the lastest ending time
        int minStart = intervals[0].start, maxEnd = intervals[0].end;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < minStart) minStart = intervals[i].start;
            if (intervals[i].end > maxEnd) maxEnd = intervals[i].end;
        }
        
        // Iterate through every minute and find the maximum number of overlapped intervals which 
        // equals to the minimum number of conference rooms needed
        int overlaps = 0;
        for (int j = minStart; j < maxEnd; j++) {
            int overlapsPerMin = 0;
            for (int k = 0; k < intervals.length; k++) {
                if (intervals[k].start <= j && intervals[k].end > j) overlapsPerMin++; 
            }
            if (overlapsPerMin > overlaps) overlaps = overlapsPerMin;
        }
        return overlaps;
    }
}
