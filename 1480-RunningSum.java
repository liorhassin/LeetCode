class RunningSum {
    //Complexity O(n)
    public int[] runningSum(int[] nums) {
        int[] finalResult = new int[nums.length];
        if(nums.length == 0){
            return nums;
        }
        finalResult[0] = nums[0];
        for(int i = 1; i<nums.length; i++){
            finalResult[i] = nums[i] + finalResult[i-1];
        }
        return finalResult;
    }
}
