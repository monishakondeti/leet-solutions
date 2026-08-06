class Solution {
    public int climbStairs(int n) {
        //for all single steps it has one way
        // for all double steps ... means it is fibinoccai series
        return fibo(n);
    }
    /*int fibo(int n){
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return fibo(n-2) + fibo(n-1);
    } */
    //for dynamic programming of fibo
    int fibo(int n){
        //fibo series is 1,2,3,5,8,13,...
        if(n==1){
            return 1;
        }
        int first = 1; //1st num
        int second = 2; //2nd num
        //from 3rd step
        for(int i = 3;i<=n;i++){
            int current = first+second;
            first = second;
            second = current;
        }
        return second;
    }
}