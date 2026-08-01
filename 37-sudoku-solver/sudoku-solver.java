class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    boolean solve(char[][] board){
        int n = board.length;
        int row = -1;
        int col = -1;
        boolean emptyLeft = true;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(board[i][j] == '.'){
                    //means no digit in the check box
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
            if(emptyLeft == false){
                break;
            }
        }
        if(emptyLeft == true){
            return true; //this is the baseCase
        }
        //backtrack
        for(char ch = '1';ch<='9';ch++){
            if(isSafe(board,row,col,ch)){
                board[row][col] = ch;
                if(solve(board)){
                    return true;
                }else{
                    //now we do backtrack
                    board[row][col] = '.';
                }
            }
        }
        return false; //if nothing is worked suduko is not solved
    }
    boolean isSafe(char[][] board,int row,int col,char num){
        //check row
        for(int i = 0; i<board.length;i++){
            //check if num is in row or now
            if(board[row][i] == num){
                return false;
            }
        }
        //check col
        for(char[] nums : board){
            //check if num is in row or now
            if(nums[col] == num){ //same col for diff rows
                return false;
            }
        }
        //now check for each box
        int sqrt = (int)(Math.sqrt(board.length));
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;
        for(int r = rowStart; r < rowStart + sqrt ; r++){
            for(int c = colStart ; c < colStart + sqrt ;c++){
                if(board[r][c] == num){
                    return false;
                }
            }
        }
        return true;
    }
}