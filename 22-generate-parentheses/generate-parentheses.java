class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        backtrack(n,sb,0,0);
        return ans;
    }
    void backtrack(int n ,StringBuilder current,int open,int close){
        if(open == n && close == n){
            ans.add(current.toString());
            return;
        }
        //we can add open or close,but close only if there exists its open
        if(open<n){
            //we can add open
            current.append('(');
            backtrack(n,current,open+1,close);
            current.deleteCharAt(current.length()-1);
        }
        if(close<open){
            current.append(')');
            backtrack(n,current,open,close+1);
            current.deleteCharAt(current.length()-1);
        }
    }
}