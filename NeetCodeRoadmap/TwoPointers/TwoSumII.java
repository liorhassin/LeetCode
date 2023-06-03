package NeetCodeRoadmap.TwoPointers;

import java.util.Arrays;

public class TwoSumII {

    public static int[] twoSumIISortedArrayGoodSolution(int[] numbers, int target){
        int startP = 0, endP = numbers.length-1;
        while(startP < endP){
            int currentSum = numbers[startP] + numbers[endP];
            if(currentSum == target) return new int[]{startP+1, endP+1};
            else if(currentSum > target) endP--;
            else startP++;
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println("Checking good solution:");
        System.out.println(Arrays.toString(twoSumIISortedArrayGoodSolution(new int[]{1, 2, 3, 4}, 7))); //Expected [3,4]
        System.out.println(Arrays.toString(twoSumIISortedArrayGoodSolution(new int[]{7, 9, 14}, 21))); //Expected [1,3]
        System.out.println(Arrays.toString(twoSumIISortedArrayGoodSolution(new int[]{}, 10))); //Expected []
        System.out.println(Arrays.toString(twoSumIISortedArrayGoodSolution(new int[]{3,5,7,9,10,11,12}, 22))); //Expected [5,7]
    }
}
