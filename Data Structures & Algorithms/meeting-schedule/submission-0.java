/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return true;
        }

        // Sort meetings by start time using fields instead of array indices
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        for (int i = 1; i < intervals.size(); i++) {
            // Check if current meeting starts before the previous ends
            if (intervals.get(i).start < intervals.get(i - 1).end) {
                return false;
            }
        }

        return true;

    }
}
