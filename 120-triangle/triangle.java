class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        return solve(triangle,0,0,dp,visited);
    }
    int solve(List<List<Integer>> triangle,int row,int col,int[][] dp,boolean[][] visited){

        if(row==triangle.size()-1){
            return triangle.get(row).get(col);
        }

        //dp stores minTotal
        if(visited[row][col]){
            //already calculated so return the dp itself
            return dp[row][col];
        }
        //we increment row everysingle time we check and can check for 2 times col and col+1
        int down = solve(triangle,row+1,col,dp,visited);
        int downRight = solve(triangle,row+1,col+1,dp,visited);
        int sum = triangle.get(row).get(col) + Math.min(down,downRight);
        dp[row][col] = sum;
        visited[row][col]=true;
        return sum;
    }
}