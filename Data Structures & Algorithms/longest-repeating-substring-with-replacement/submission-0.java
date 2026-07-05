public class Solution {
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int left = 0;
        int maxFrequency = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            // Add current character to the frequency map
            int charIdx = s.charAt(right) - 'A';
            counts[charIdx]++;
            
            // Track the highest frequency of any single character seen in a window
            maxFrequency = Math.max(maxFrequency, counts[charIdx]);

            // Calculate the current window size
            int windowLength = right - left + 1;

            // If the number of characters to replace is greater than k, shrink the window
            if (windowLength - maxFrequency > k) {
                counts[s.charAt(left) - 'A']--;
                left++; // Move left pointer forward
            }

            // Since the window only expands when valid, update max length encountered
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
