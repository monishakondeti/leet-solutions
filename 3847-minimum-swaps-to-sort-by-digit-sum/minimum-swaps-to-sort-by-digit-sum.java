class Solution {
    public int minSwaps(int[] nums) {
        Integer[] sorted = new Integer[nums.length];
        for(int i = 0;i<nums.length;i++){
            sorted[i] = nums[i];
        }
        sortedOrder(sorted);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        return cycle(sorted,map,nums);
    }
    int sumOfDigits(int num){
        //num is each number in nums
        int sum = 0;
        while(num > 0){
            int digit = num%10;
            sum += digit;
            num = num/10;
        }
        return sum;
    }
    void sortedOrder(Integer[] nums){
        //instead of sorting manually for O(n^2) we use java built in coustom sorting using lambda function
        //java doesnt provide comparator for primitive data type int
        Arrays.sort(nums,(a,b)->{
            if(sumOfDigits(a) != sumOfDigits(b)){
                return Integer.compare(sumOfDigits(a),sumOfDigits(b));
            }
            //if both sum equal means we sort in ascending order so,
            return Integer.compare(a,b);
        });
    }
    int cycle(Integer[] sorted,HashMap<Integer,Integer> map,int[] nums){
        int swaps = 0;
        boolean[] visited = new boolean[nums.length];
        for(int i = 0;i<nums.length;i++){
            if(visited[i]){
                continue;
            }
            //starts new cycle
            int count = 0;//count tells number of positions a cycle contains
            int current = i;
            while(!visited[current]){
                visited[current] = true;
                //now we need to change the i index to the index we map and count
                int next = map.get(sorted[current]);
                current = next;
                count++;
            }
            swaps += count -1;
        }
        return swaps;
    }
}