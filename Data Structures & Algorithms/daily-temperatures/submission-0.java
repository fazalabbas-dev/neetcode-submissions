class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        // Stack stores indices of the days
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            // While current temperature is warmer than the temperature at the stack's top index
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex; // Calculate days to wait
            }
            // Push current day's index onto the stack
            stack.push(i);
        }
        
        return result;
    }
}
