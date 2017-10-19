class LongestPalindrome {
    public String longestPalindrome(String s) {
        char[] c = s.toCharArray();
        boolean[][] dp = new boolean[c.length][c.length];
        int maxLength = 1;
        int start = 0;
        int end = 0;
        for(int i = c.length-1; i >= 0; i--) {
            for(int j = i; j < c.length; j++) {
                if((i+1 > j-1 || dp[i+1][j-1]) && c[i] == c[j]) {
                    dp[i][j] = true;
                    if(j-i+1 > maxLength) {
                        maxLength = j - i + 1;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end+1);
    }
}
