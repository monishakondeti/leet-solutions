class Solution {
    public int shipWithinDays(int[] weights, int days) {
        return binarySearch(weights,days);
    }
    int binarySearch(int[] arr,int days){
        int start = max(arr);//min capacity of ship will be max of a single package , if we take 1st element then the max package cant be fit in the ship
        int end = sum(arr);//max package weight
        //we search through min to max capacity a ship can carry and find the least capacity can be carried within given days
        while(start<=end){
            int mid = start + (end-start)/2; // Assume the ship capacity is mid,Check if this capacity is enough.
            int totalDays = numOfDays(arr,mid);
            if(totalDays <= days){
               end = mid - 1;
            }else{
               start = mid + 1;
            }
        }
        return start;
    }
    //min weight of ship is equal to max of package
    int numOfDays(int[] weights,int capacity){
        int days = 1;//at first always day will start with 1
        int weightOfPackage = 0;
        for(int i = 0;i<weights.length;i++){
            //here we are adding each weight and comparing with least weight and keep on adding, till we reach the end and count num of days , and also compare the days and change the mid value
            //add weights till it reach the capacity and increase num of days
            if((weightOfPackage + weights[i])<=capacity){
                weightOfPackage += weights[i];
            }else{
                days++;
                weightOfPackage = weights[i];
            }
        }
        return days;
    }
    int max(int[] arr){
        int max = arr[0];
        for(int num : arr){
            if(num > max){
                max = num;
            }
        }
        return max;
    }
    int sum(int[] arr){
        int sum = 0;
        for(int i = 0;i<arr.length;i++){
            sum += arr[i];
        }
        return sum;
    }
}