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
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[]{};
        }

        int n = nums.length;
        // Total number of sliding windows is exactly (n - k + 1)
        int[] result = new int[n - k + 1];
        int ri = 0; // Index pointer for our result array

        // Deque to store array INDICES
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // Step 1: Remove indices that have fallen out of the left boundary
            // The valid left boundary for the current window is (i - k + 1)
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Step 2: Maintain monotonic decreasing order
            // Kick out any indices from the back whose values are smaller than nums[i]
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Step 3: Add the current element's index to the back
            deque.offerLast(i);

            // Step 4: Record the maximum once our first window is fully formed
            // The first window finishes forming when index 'i' reaches (k - 1)
            if (i >= k - 1) {
                result[ri++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}