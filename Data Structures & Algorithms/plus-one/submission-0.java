class Solution {
    public int[] plusOne(int[] digits) {
        // Start from the rightmost digit
        for (int i = digits.length - 1; i >= 0; i--) {
            // If the current digit is less than 9, just increment it and return
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            
            // If the digit is 9, it becomes 0 (and the loop carries over to the next digit)
            digits[i] = 0;
        }
        
        // If we exit the loop, it means ALL digits were 9 (e.g., [9, 9, 9] became [0, 0, 0])
        // We need an extra 1 at the front (e.g., [1, 0, 0, 0])
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1; // Remaining indices default to 0 in Java arrays
        
        return newDigits;
    }
}
