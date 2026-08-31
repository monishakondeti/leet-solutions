class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //we take row and col of obstacleGrid for dp
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int row = 0;row<dp.length;row++){
            for(int col = 0;col<dp[0].length;col++){
                dp[row][col] =-1;
            }
        }
        return count(obstacleGrid,0,0,dp);
    }
    int count(int[][] maze,int r,int c,int[][] dp){
        //we can move either to down or to right but here e have extra obstacles then we should not move there 
        //we know that there is obstacle if it is 1, if the next move has 0 then we had no obstacle
        if(maze[r][c] == 1){//means we got obstacle here
            return 0;
        }
        if(r == maze.length-1 && c == maze[0].length-1){
            return 1;
        }
        if(dp[r][c] != -1){
            return dp[r][c];
        }
        int down = 0;
        int right = 0;
        if(r < maze.length-1){
            //we can still move down
            down = count(maze,r+1,c,dp);
        }
        if(c < maze[0].length-1){
            //we can still move right
            right = count(maze,r,c+1,dp);
        }
        dp[r][c] = down+right;
        return dp[r][c];
    }
}