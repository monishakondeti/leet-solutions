class Solution {
    public int maximalSquare(char[][] matrix) {
        //if the current cell is 0 leave,else check right bottom and diagonal cell
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i =0;i<dp.length;i++){
            for(int j =0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        //we need largest side but through recursion we are getting size only,everytime we find we need to get get the largest side and return the matrix size mans largestSide*largestSide
        int largestSide=0;
        for(int i =0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                int side = maxMin(matrix,i,j,dp);
                largestSide = Math.max(largestSide,side);
            }
        }
        return largestSide*largestSide;
    }
    int maxMin(char[][] mat,int r,int c,int[][] dp){
        if(mat[r][c] == '0'){
            return 0;
        }

        if(dp[r][c] !=-1){//dp already calculated
            return dp[r][c];
        }

        int down = 0;
        int right=0;
        int diag=0;
        //the below checks only if the cell we have contain '1'
        //now check next row col and diagonal
        if(r<mat.length-1){
            //we can move down
            down = maxMin(mat,r+1,c,dp);
        }
        if(c<mat[0].length-1){
            right =maxMin(mat,r,c+1,dp);
        }
        if(r<mat.length-1 && c<mat[0].length-1){
            //we can also check diagnoal
            diag=maxMin(mat,r+1,c+1,dp);
        }
        dp[r][c] = 1+Math.min(down,Math.min(right,diag));
        return dp[r][c];
    }
}