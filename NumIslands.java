class NumIslands {
    int[] rowsDirection = new int[]{1, -1, 0, 0};
    int[] columnsDirection = new int[]{0, 0, 1, -1};
    
    public boolean valid(int i, int j, int n, int m){
        if(i >= 0 && j >= 0 && i < n && j < m) {
            return true;
        } else {
            return false;
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        if(n == 0)
            return 0;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int islandCount = 0;
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) { // New Island, expand.
                    islandCount++;
                    Queue<int[]> queue = new LinkedList<int[]>();
                    queue.add(new int[] {i, j});
                    while(!queue.isEmpty()) {
                        int[] entry = queue.poll();
                        int nodei = entry[0];
                        int nodej = entry[1];
                        for(int k = 0; k < rowsDirection.length; k++) {
                            int newNodei = nodei + rowsDirection[k];
                            int newNodej = nodej + columnsDirection[k];
                            if(valid(newNodei, newNodej, n, m) && !visited[newNodei][newNodej] && grid[newNodei][newNodej] == '1') {
                                visited[newNodei][newNodej] = true;
                                queue.add(new int[]{newNodei, newNodej});
                            }
                        }
                    }
                }
            }
        }
        return islandCount;
    }
}
