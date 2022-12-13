class IsSubsequence {
    //Complexity O(n) -> n is the length of the string t
    public boolean isSubsequence(String s, String t) {
        int tCurrent = 0;
        int sCurrent = 0;
        if(s.length() == 0){
            return true;
        }
        while(tCurrent < t.length()){
            if(s.charAt(sCurrent) == t.charAt(tCurrent)){
                sCurrent++;
            }
            if(sCurrent > s.length()-1){
                return true;
            }
            tCurrent++;
        }
        return false;
    }
}