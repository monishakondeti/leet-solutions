import java.util.*;

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        return search(nums,target);
    }
    List<Integer> search(int[] nums,int target){
        List<Integer> ans = new ArrayList<Integer>();
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid] == target){
                ans.add(mid);
                //check mid prev and next if exists
                int i = mid-1;
                int j = mid+1;
                while(i>=0){
                    if(nums[i] == target){
                        ans.add(i);
                        i--;
                    }else{
                        break;
                    }
                }
                while(j<nums.length){
                    if(nums[j] == target){
                        ans.add(j);
                        j++;
                    }else{
                        break;
                    }
                }
                break;
            }else if(nums[mid]<target){
                left = mid+1;
            }else{
                right=mid-1;
            }
        }
        Collections.sort(ans);
        return ans;
    }
}