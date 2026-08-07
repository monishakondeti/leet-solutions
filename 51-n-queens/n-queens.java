class Solution {
    List<List<String>> outer = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        queens(board,0);
        return outer;
    }
    void queens(boolean[][] board,int row){
        if(row == board.length){
            List<String> inner = new ArrayList<>();
            for(int i = 0;i<board.length;i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0;j<board.length;j++){
                    if(board[i][j]){
                        sb.append('Q');
                    }else{
                        sb.append('.');
                    }
                }
                inner.add(sb.toString());
            }
            outer.add(inner);
            return;
        }
        for(int col = 0;col<board.length;col++){
            if(isSafe(board,row,col)){
                board[row][col] = true;
                queens(board, row + 1);
                board[row][col] = false;
            }
        }
        return;
    }
    boolean isSafe(boolean[][] board,int row,int col){
        //check vertical row
        for(int i = 0;i<row;i++){
            if(board[i][col]){
                //means queen over there so it is not safe
                return false;
            }
        }
        int maxLeft = Math.min(row,col);
        for(int i = 1;i<=maxLeft;i++){ //we go left by subtracting 1 so i = 1
            if(board[row-i][col-i]){
                return false;
            }
        }
        int maxRight = Math.min(row,board.length - col - 1);
        for(int i = 1;i<=maxRight;i++){ //we go left by subtracting 1 so i = 1
            if(board[row-i][col+i]){
                return false;
            }
        }
        return true;
    }
}