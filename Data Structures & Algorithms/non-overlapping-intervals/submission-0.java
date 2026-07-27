class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return 0;
        }

        // Sort intervals by their end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int removals = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            // If current interval starts before the previous one ends -> Overlap!
            if (intervals[i][0] < prevEnd) {
                removals++;
            } else {
                // Non-overlapping -> Update the end time to the current interval's end
                prevEnd = intervals[i][1];
            }
        }

        return removals;
    }
}
