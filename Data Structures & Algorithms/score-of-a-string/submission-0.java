class Solution {
    public int scoreOfString(String s) {
int diference=0;
        for(int i=1;i<s.length();i++){
            char previous=s.charAt(i-1);
            char current=s.charAt(i);
            diference+= Math.abs(current-previous);
        }
        return diference;
        
    }
}