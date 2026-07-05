public class Solution {
    public int maxArea(int[] heights) {
        int maxWater = 0;
        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            // Calculate width between the two bars
            int width = right - left;
            
            // The limiting height is the shorter bar
            int currentHeight = Math.min(heights[left], heights[right]);
            
            // Calculate current water capacity
            int currentWater = width * currentHeight;
            
            // Track the maximum water found so far
            maxWater = Math.max(maxWater, currentWater);
            
            // Move the pointer that points to the shorter bar
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}
