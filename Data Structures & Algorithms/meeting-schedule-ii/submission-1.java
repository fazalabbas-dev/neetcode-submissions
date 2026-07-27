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
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return 0;
        }

        // 1. Sort meetings by start time
        Collections.sort(intervals, (a,b) -> Integer.compare(a.start,b.start));

        // 2. Min-heap to keep track of meeting end times
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add the end time of the first meeting
        minHeap.offer(intervals.get(0).end);

        for (int i = 1; i < intervals.size(); i++) {
            // If the room with the earliest end time is free, reuse it
            if (intervals.get(i).start >= minHeap.peek()) {
                minHeap.poll();
            }

            // Push the current meeting's end time into the heap
            minHeap.offer(intervals.get(i).end);
        }

        // The total number of rooms required is the heap size
        return minHeap.size();

    }
}
