class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length()+1][p.length()+1];
        return check(s,p,0,0,dp);
    }
    boolean check(String s,String p,int i,int j,Boolean[][] dp){
        if(j == p.length()){ //pattern is done means string also need to be done
            if(i == s.length()){
                return true;
            } 
            return false;
        }
        //base condition for dp
        if(dp[i][j] != null){
            return dp[i][j];
        }
        boolean firstMatch = false;
        if(i<s.length()){
            if(s.charAt(i) == p.charAt(j)){
                firstMatch=true;
            }else if(p.charAt(j)=='.'){
                firstMatch=true;
            }
        }
        //if * we have two cases zero occurances or many preceding occurances
        if(j+1<p.length() && p.charAt(j+1) =='*'){
            //many occurances is possible only when prev is c
            dp[i][j] = check(s,p,i,j+2,dp) || firstMatch && check(s,p,i+1,j,dp);
            return dp[i][j];
        }else{
            if(firstMatch){
                dp[i][j] = check(s,p,i+1,j+1,dp);
                return dp[i][j];
            }else{
                return dp[i][j] = false;
            }
        }
    }
}