public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0; // Water cannot be trapped with fewer than 3 bars
        }

        int left = 0;
        int right = height.length - 1;
        
        int leftMax = height[left];
        int rightMax = height[right];
        int totalWater = 0;

        while (left < right) {
            // Process from the side that has the smaller structural boundary
            if (leftMax <= rightMax) {
                left++;
                // Update the maximum wall seen from the left side
                leftMax = Math.max(leftMax, height[left]);
                // Trapped water is the boundary height minus the bar's own height
                totalWater += leftMax - height[left];
            } else {
                right--;
                // Update the maximum wall seen from the right side
                rightMax = Math.max(rightMax, height[right]);
                // Trapped water is the boundary height minus the bar's own height
                totalWater += rightMax - height[right];
            }
        }

        return totalWater;
    }
}
