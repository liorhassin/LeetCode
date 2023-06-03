package NeetCodeRoadmap.TwoPointers;

import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> threeSumDecentSolution(int[] nums){
        Arrays.sort(nums); //O(nlog(n))
        List<List<Integer>> results = new ArrayList<>();
        for(int i = 0; i < nums.length-2; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int startP = i+1;
            int endP = nums.length-1;
            while(startP < endP) {
                int currentSum = nums[i] + nums[startP] + nums[endP];
                if (currentSum == 0) {
                    List<Integer> newTriplet = new ArrayList<>();
                    newTriplet.add(nums[i]);
                    newTriplet.add(nums[startP]);
                    newTriplet.add(nums[endP]);
                    while(startP < endP && nums[startP] == nums[startP+1]){
                        startP++;
                    }
                    while(startP < endP && nums[endP] == nums[endP-1]){
                        endP--;
                    }
                    results.add(newTriplet);
                    startP++;
                    endP--;
                }
                else if(currentSum > 0) endP--;
                else startP++;
            }
        }

        return results;
    }

    public static void main(String[] args) {
        System.out.println("Checking good solution:");
        System.out.println(threeSumDecentSolution(new int[]{-4,-3,-3,-2,-1,0,1,2,3,4,5,6}));
        System.out.println(threeSumDecentSolution(new int[]{1,0,-1}));
        System.out.println(threeSumDecentSolution(new int[]{-1,0,1,2,-1,-4}));
    }
}
