class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        
        // Edge Case: If s1 is longer than s2, s2 cannot contain its permutation
        if (len1 > len2) {
            return false;
        }
        
        // Frequency arrays for 'a' through 'z' (size 26)
        int[] s1Counts = new int[26];
        int[] s2Counts = new int[26];
        
        // Step 1: Initialize counts for s1 and the very first window of s2
        for (int i = 0; i < len1; i++) {
            // 'char - 'a'' converts letters to 0-25 indices (e.g., 'b' - 'a' = 1)
            s1Counts[s1.charAt(i) - 'a']++;
            s2Counts[s2.charAt(i) - 'a']++;
        }
        
        // Step 2: Immediate check for the first window
        if (Arrays.equals(s1Counts, s2Counts)) {
            return true;
        }
        
        // Step 3: Slide the window across s2
        // 'i' represents the incoming right index of the window
        for (int i = len1; i < len2; i++) {
            // Add the new character entering the window on the right
            s2Counts[s2.charAt(i) - 'a']++;
            
            // Remove the old character leaving the window on the left
            // The element leaving is always exactly 'len1' steps behind 'i'
            s2Counts[s2.charAt(i - len1) - 'a']--;
            
            // Check if our updated moving window matches the s1 target
            if (Arrays.equals(s1Counts, s2Counts)) {
                return true;
            }
        }
        
        // If we loop through the entire string without a match, return false
        return false;
    }
}
