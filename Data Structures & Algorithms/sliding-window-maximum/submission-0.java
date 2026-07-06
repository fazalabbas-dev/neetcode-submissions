class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // brute force solution 1 with time complexity is O(nxk)
        // int n = nums.length;
        // int[] result = new int[n - k + 1];

        // for (int i = 0; i <= n - k; i++) {

        //     int max = nums[i];

        //     for (int j = i; j < i + k; j++) {
        //         max = Math.max(max, nums[j]);
        //     }

        //     result[i] = max;
        // }

        // return result;



        // second solution using max heap with time complexity is O(nlogn)

        // if (nums == null || nums.length == 0 || k <= 0) {
        //     return new int[]{};
        // }

        // int n = nums.length;
        // int[] result = new int[n - k + 1];
        // int ri = 0;

        // // Max-Heap storing int[] where:
        // // arr[0] = value of the element
        // // arr[1] = index of the element
        // // If values are equal, sort by index descending (or ascending, doesn't matter for max)
        // PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        // for (int i = 0; i < n; i++) {
        //     // 1. Add current element and its index to the heap
        //     maxHeap.offer(new int[] {nums[i], i});

        //     // 2. Lazy Deletion: Clean up stale elements from the top
        //     // If the max element's index is outside the current window boundary, discard it
        //     while (maxHeap.peek()[1] < i - k + 1) {
        //         maxHeap.poll();
        //     }

        //     // 3. Once the first window is fully formed, record the max
        //     if (i >= k - 1) {
        //         result[ri++] = maxHeap.peek()[0];
        //     }
        // }

        // return result;


        // third most effiecient mechanism using deque
        int n = nums.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        int index = 0;

        for (int i = 0; i < n; i++) {

            // Remove indices outside the current window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove smaller values from the back
            while (!deque.isEmpty() &&
                   nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // Add current index
            deque.offerLast(i);

            // Window is complete
            if (i >= k - 1) {
                result[index++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}