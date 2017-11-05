class FindRedundantConnection {
    
    public boolean canConnect(int[][] graph, int s, int t, boolean[] visited) {
        if(graph[s][t] == 1)
            return true;
        for(int i = 0; i < graph.length; i++) {
            if(graph[s][i] == 1 && !visited[i]) {
                visited[i] = true;
                if(canConnect(graph, i, t, visited)) {
                    return true;
                }
                visited[i] = false;
            }
        }    
        return false;
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        int[][] graph = new int[edges.length][edges.length];
        for(int i = 0; i < edges.length; i++) {
            graph[edges[i][0]-1][edges[i][1]-1] = 1;
            graph[edges[i][1]-1][edges[i][0]-1] = 1;
        }
        for(int i = edges.length - 1; i >= 0; i--) {
            int s = edges[i][0]-1;
            int t = edges[i][1]-1;
            graph[s][t] = 0;
            graph[t][s] = 0;
            if(canConnect(graph, s, t, new boolean[edges.length]))
                return edges[i];
            graph[s][t] = 1;
            graph[t][s] = 1;
        }       
        return null;
    }
}

