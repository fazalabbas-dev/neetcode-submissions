
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Step 1: Sort the array
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Optimization: If the smallest number is greater than 0, a 0 sum is impossible
            if (nums[i] > 0) {
                break;
            }
            
            // Step 2: Skip duplicate elements for the first position
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Step 3: Initialize two pointers for the remaining elements
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    // Unique triplet found
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Step 4: Move pointers and skip duplicates for left and right
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    
                    // Final move to step onto the new unique numbers
                    left++;
                    right--;
                    
                } else if (sum < 0) {
                    left++; // Sum too small, move to a larger value
                } else {
                    right--; // Sum too large, move to a smaller value
                }
            }
        }
        
        return result;
    }
}
