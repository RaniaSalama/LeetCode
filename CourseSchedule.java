class CourseSchedule {
    
    ArrayList<ArrayList<Integer>> prerequisitesGraph;
    public int[] bfs (int[] degrees) {
        int n = prerequisitesGraph.size();
        int[] order = new int[n];
        int index = 0;
        Queue<Integer> toVisit = new LinkedList<Integer>();
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(degrees[i] == 0) {
                toVisit.add(i);
                visited[i] = true;
            }
        }
        while(!toVisit.isEmpty()) {
                Integer j = toVisit.poll();
                order[index++] = j;
                // Update graph
                ArrayList<Integer> jNeighbors = prerequisitesGraph.get(j);
                for(Integer jNeighbor: jNeighbors) {
                    degrees[jNeighbor]--;
                    if(!visited[jNeighbor] && degrees[jNeighbor] == 0){
                        toVisit.add(jNeighbor);
                        visited[jNeighbor] = true;
                    }
                }
        }
        if(index == n)
            return order;
        else
            return new int[0];
    }
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Construct graph.
        prerequisitesGraph = new ArrayList<ArrayList<Integer>> ();
        for(int i = 0; i < numCourses; i++) {
            prerequisitesGraph.add(new ArrayList<Integer>());
        }
        int[] degrees = new int[numCourses];
        HashSet<Integer> toVisit = new HashSet<Integer>();
        for(int i = 0; i < prerequisites.length; i++) {
            int[] prerequist = prerequisites[i];
            prerequisitesGraph.get(prerequist[1]).add(prerequist[0]);
            degrees[prerequist[0]]++;
        }
    
        return bfs(degrees);    
    }
}
