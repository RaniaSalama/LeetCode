class FindItinerary {
    String result = "";
    public void getItinerary(int s, int[][] graph, int visitedEdges, String ans, 
                             HashMap<Integer, String> reverseIds) {
        if(visitedEdges == 0) {
            if(result == "" || ans.compareTo(result) < 0)
                result = ans;
            return;
        }
        for(int i = 0; i < graph.length; i++) {
            if(graph[s][i] > 0) {
                graph[s][i]--;
                String iAirport = reverseIds.get(i);
                getItinerary(i, graph, visitedEdges-1, ans+","+iAirport, reverseIds);
                if(result != "")
                    return;
                graph[s][i]++;
            }
        }
    }
    public List<String> findItinerary(String[][] tickets) {
        TreeMap<String, Integer> airports = new  TreeMap<String, Integer>();
        for(int i = 0; i < tickets.length; i++) {
                airports.put(tickets[i][0], 0);
                airports.put(tickets[i][1], 0);
        }
        HashMap<String, Integer> ids = new HashMap<String, Integer> ();
        HashMap<Integer, String> reverseIds = new HashMap<Integer, String> ();
        
        int id = 0;
        for(String airport : airports.keySet()) {
            if(!ids.containsKey(airport)) {
                ids.put(airport, id);
                reverseIds.put(id++, airport);
            }
        }
        int[][] graph = new int[ids.size()][ids.size()];
        for(int i = 0; i < tickets.length; i++) {
            int s = ids.get(tickets[i][0]);
            int t = ids.get(tickets[i][1]);
            graph[s][t]++;
        }
        int s = ids.get("JFK");
        getItinerary(s, graph, tickets.length, "JFK", reverseIds);
        List<String> resultList = new ArrayList<String> ();
        String[] resultSplit = result.split(",");
        for(String airport : resultSplit)
            resultList.add(airport);
        return resultList;
    }
}
