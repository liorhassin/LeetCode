class IsomorphicStrings {
    //Complexity O(n)
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] ascii_1 = new int[256];
        int[] ascii_2 = new int[256];
        for(int i = 0; i < s.length(); i++){
            if(ascii_1[s.charAt(i)] != ascii_2[t.charAt(i)])
                return false;
            ascii_1[s.charAt(i)] = 1 + i;
            ascii_2[t.charAt(i)] = 1 + i;
        }
        return true;
    }
}