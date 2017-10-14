class SurroundedRegions {
    int[] rowDirections = new int[] {1, -1, 0, 0};
    int[] colDirections = new int[] {0, 0, 1, -1};
    
    public boolean valid(int i, int j, int n, int m) {
        if(i >= 0 && j >= 0 && i < n && j < m) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isBorder(int i, int j, int n, int m) {
        if(i == 0 || j == 0 || i == n-1 || j == m-1) {
            return true;
        } else {
            return false;
        }
    }
    
    // usage = 0, check valid.
    // usage = 1, color region.
    public boolean BFS(char[][] board, int usage, int i, int j, boolean[][] visited) {
        int n = board.length;
        int m = board[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        boolean valid = true;
        while(!queue.isEmpty()) {
            int[] entry = queue.poll();
            int nodei = entry[0];
            int nodej = entry[1];
            if(usage == 1) {
                board[nodei][nodej] = 'X';
            }
            if(usage == 0 && isBorder(nodei, nodej, n, m)) {
                valid = false;
            }
            for(int r = 0; r < rowDirections.length; r++) {
                int newNodei = nodei + rowDirections[r];
                int newNodej = nodej + colDirections[r];
                if(valid(newNodei, newNodej, n, m) && !visited[newNodei][newNodej]
                   && (board[newNodei][newNodej] == 'O')) {
                    queue.add(new int[]{newNodei, newNodej});
                    visited[newNodei][newNodej] = true;
                }
            }
        }
        return valid;
    }
    
    public void copy(boolean[][] m1, boolean[][] m2) {
        for(int i = 0; i < m1.length; i++) {
            for(int j = 0; j < m1[0].length; j++) {
                m2[i][j] = m1[i][j];
            }
        }
    }
    
    public void solve(char[][] board) {
        int n = board.length;
        if(n == 0) {
            return;
        }
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 'O' && !visited[i][j]) {
                    // check if we can reach boarder from it.
                    boolean[][] visitedPassOne = new boolean[n][m];
                    copy(visited, visitedPassOne);
                    boolean valid = BFS(board, 0, i, j, visitedPassOne);   
                    if(valid) { // need to be colored 'x'!
                        BFS(board, 1, i, j, visited);
                    } else {
                        visited = visitedPassOne;
                    }
                }
            }
        }
    }
}
