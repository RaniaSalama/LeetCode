class Solution {

    public boolean checkIndex(int i, int j, int n, int m) {
        if(i >= 0 && j >= 0 && i < n && j < m) {
            return true;
        } else {
            return false;
        }
    }
    
    int[] rowIndex = new int[] {1, 0, -1};
    int[] colIndex = new int[] {1, 0, -1};
    public int getLiveNeighborCount(int[][] board, int i, int j) {
        int liveNeighborCount = 0;
        for(int r = 0; r < rowIndex.length; r++) {
            for(int c = 0; c < colIndex.length; c++) {
                if(checkIndex(i+rowIndex[r], j+colIndex[c], board.length, board[0].length)) {
                    if(Math.abs(board[i+rowIndex[r]][j+colIndex[c]]) == 1) {
                        liveNeighborCount += 1;
                    }
                }
            }
         }
        return liveNeighborCount - board[i][j];
    }
    
    public void gameOfLife(int[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                int liveNeighbors = getLiveNeighborCount(board, i, j);
                if(board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) { // live cell
                    board[i][j] = -1; // die!
                } else if(board[i][j] != 1 && (liveNeighbors == 3)) { // dead cell
                    board[i][j] = 2; // was dead become a live!
                }
            }
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {           
                if(board[i][j] == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == -1) {
                    board[i][j] = 0;
                }
            }
        }
    
}
}
