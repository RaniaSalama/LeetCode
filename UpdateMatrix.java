class UpdateMatrix {
 
    public boolean valid(int i, int j, int n, int m) {
        if(i >= 0 && j >= 0 && i < n && j < m)
            return true;
        else
            return false;
    }
    
    int[] rows = new int[] {-1,1,0,0};
    int[] cols = new int[] {0,0,-1,1};
    public int[][] updateMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        int[][] distances = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    queue.add(new int[] {i, j, 0});
                } else {
                    distances[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while(!queue.isEmpty()) {
            int[] entry = queue.poll();
            int nodei = entry[0];
            int nodej = entry[1];
            int distance = entry[2];
            for(int k = 0; k < rows.length; k++) {
                int neighborNodei = nodei+rows[k];
                int neighborNodej = nodej+cols[k];
                if(valid(neighborNodei, neighborNodej, n, m)) {
                    if(distances[neighborNodei][neighborNodej] > distance + 1) {
                            queue.add(new int[] {neighborNodei, neighborNodej, distance + 1});
                            distances[neighborNodei][neighborNodej] = distance + 1;
                    }
                }
            }
        }
        return distances;
    }
}

