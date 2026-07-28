class Solution {
    public int appendCharacters(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        
        int i = 0; // Pointer for s
        int j = 0; // Pointer for t
        
        // Scan both strings to find the longest matching prefix of t in s
        while (i < sLen && j < tLen) {
            if (s.charAt(i) == t.charAt(j)) {
                j++; // Move t pointer only when a character matches
            }
            i++; // Always move s pointer forward
        }
        
        // The remaining unmatched characters of t must be appended
        return tLen - j;
        
    }
}