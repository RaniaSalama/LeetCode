class FindCircleNum {
    public int findCircleNum(int[][] M) {
        Queue<Integer> queue = new LinkedList<Integer> ();
        boolean[] visited = new boolean[M.length];
        int componentNum = 0;
        for(int i = 0; i < M.length; i++){
            if(!visited[i]) {
                componentNum++;
                queue.add(i);
                visited[i] = true;
                while(!queue.isEmpty()) {
                    int node = queue.poll();
                    for(int j = 0; j < M.length; j++) {
                        if(M[node][j] == 1 && !visited[j]) {
                            queue.add(j);
                            visited[j] = true;
                        }
                    }
                }
            }
        }
        return componentNum;
    }
}
