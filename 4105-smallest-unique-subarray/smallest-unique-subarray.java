class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        int ans = binarySearch(nums,1,nums.length);
        return ans;
    }
    int binarySearch(int[] nums,int start,int end){
        //we use bs to m=find the mind and mid is what here length of subarray, and find all subarrays of length mid and its frequency , if it has frequescy 1 then move end to mid-1 and check mid value for that and repeat, if frequency is greater than 1 then move end as mid+1,
        //we do this cz if a subarray is unique than atleast one subarray greater than its length will be unique cz it might extend it... but if it not unique subarray less than its length might also be not unique
        
        int ans=nums.length;
        while(start<=end){
            int mid = start +(end-start)/2;
            boolean result = check(nums,mid);
            if(result){
                //it means we got atleast one subarray of that length unique
                ans=mid;
                end = mid-1;//searches for smaller length coz mid value reduces
            }else{
                start = mid+1;//search for larger subarray length as mid value increases
            }
        }
        return ans;
    }
    boolean check(int[] nums,int mid){
        //we need to use hashmap inorder to store its frequency of the subarray
        HashMap<Long,Integer> map = new HashMap<>();//coz it maps with array list of subarray to its frequency
        int i = 0;
        int j = i+mid-1;
        //now create a 1st window roll hash
        long hash = 0;
        long base =10;
        long mod = 1_000_000_007;
        long power =1;
        for(int k =0;k<mid-1;k++){
            power = (power*base)%mod;
        }
        //1st create the 1st hash and then do roll back
        for(int k =0;k<mid;k++){
            hash = (hash*base+nums[k])%mod;
        }
        map.put(hash,1);
        //now do roll hash
        while(j<nums.length-1){
            int outgoing=nums[i];
            int incoming = nums[j+1];
            //hash = (((hash-(outgoing*power))*base)+incoming)%m; but we may get negative value so to overcome it we divide into 2 halves like
            hash = (hash-(outgoing*power) %mod + mod)%mod;
            hash = ((hash*base)+incoming)%mod;
            if(map.containsKey(hash)){//checks if the subarray already exists in the map
               int frequency = map.get(hash);
               map.put(hash,frequency+1);
            }else{
               map.put(hash,1);
            }
            i++;
            j++;
        }
        for(int freq:map.values()){
            if(freq==1){
                //unique subarray exits
                return true;
            }else{
                //unique subarray doesnt exists
                continue;
            }
        }
        return false;
    }
}