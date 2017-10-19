class CountSubstrings {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        // dp[i][j] is substring from i to j a plandrome?
        int count = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            for(int j = i; j < s.length(); j++) {
                if((i+1 > j-1 || dp[i+1][j-1]) && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;    
    }
    
}
