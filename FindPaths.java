class FindPaths {
    
    
    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};
    
    public boolean valid(int i, int j, int m, int n) {
        if(i >= 0 && j >= 0 && i < m && j < n) {
            return true;
        } else {
            return false;
        }
            
    }
    
    double[][][] dp = null;
    public double dfs(int m, int n, int N, int i, int j) {
        if(dp == null) {
            dp = new double[m][n][N];
            for(int mm = 0; mm < m; mm++) {
                for(int nn = 0; nn < n; nn++) {
                    for(int NN = 0; NN < N; NN++) {
                        dp[mm][nn][NN] = -1;
                    }
                }
            }
        }
        if(N == 0) {
            return 0;
        }
        double count = 0;
        for(int d = 0; d < dx.length; d++) {
            if(valid(i + dx[d], j + dy[d], m, n)) {
                if(dp[i+dx[d]][j+dy[d]][N-1] == -1){
                    dp[i+dx[d]][j+dy[d]][N-1] = findPaths(m, n, N - 1, i + dx[d], j + dy[d]) % 1000000007;
                }
                count += dp[i+dx[d]][j+dy[d]][N-1] % 1000000007;
            } else {
                count++;
            }
        }
        return count % 1000000007;
    }
    
    public int findPaths(int m, int n, int N, int i, int j) {
        return (int) ((dfs(m, n, N, i, j) % 1000000007));
    }
}
