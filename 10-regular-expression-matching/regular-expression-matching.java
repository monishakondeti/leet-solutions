class Solution {
    public boolean isMatch(String s, String p) {
        return check(s,p,0,0);
    }
    boolean check(String s,String p,int i,int j){
        if(j == p.length()){ //pattern is done means string also need to be done
            if(i == s.length()){
                return true;
            } 
            return false;
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
            return check(s,p,i,j+2) || firstMatch && check(s,p,i+1,j);
        }else{
            if(firstMatch){
                return check(s,p,i+1,j+1);
            }else{
                return false;
            }
        }
    }
}