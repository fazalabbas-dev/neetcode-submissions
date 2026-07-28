class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s==null || s.length()==0){
            return true;
        }
        if(t==null || t.length()==0 || t.length()<s.length()){
            return false;
        }
        int left=0;
        int count=0;
        for(int right=0;right<t.length();right++){
            char ch1=s.charAt(left);
            char ch2=t.charAt(right);
            if(ch1==ch2){
                left++;
                count++;
                if(count==s.length()){
                    break;
                }
            }

        }
        return count==s.length();
        
    }
}