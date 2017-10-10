class CombinationSum3 {

    public List<List<Integer>> solve(int k, int n, int start) {
        List<List<Integer>> allSolutions = new ArrayList<List<Integer>>();
        if(k == 1 && n >= start && n <= 9){ // Base case.
            List<Integer> solution = new ArrayList<Integer>();
            if(!solution.contains(n)){
                solution.add(n);
                allSolutions.add(solution);
            }
            return allSolutions;
        }
        if(k < 1) { // empty!
            return allSolutions;
        }
        for(int x = start; x <= 9; x++) {
            List<List<Integer>>  solutions = solve(k-1, n-x, x+1);
            for(List<Integer> solution: solutions) {
                solution.add(x);
                allSolutions.add(solution);
            }
        }
        return allSolutions;
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        return solve(k, n, 1);
    }
}

