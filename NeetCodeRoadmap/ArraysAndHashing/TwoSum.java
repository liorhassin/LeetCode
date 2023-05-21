package NeetCodeRoadmap.ArraysAndHashing;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    /**
     * Using double for-loop to iterate through the array and look for 2 numbers that can make up target num.
     * Bad solution! | Time-Complexity: O(n^2) | Space-Complexity:O(1)
     * @param arr - Numbers to iterate on and search for two numbers that make up target.
     * @param target - Target number to calculate using two numbers from arr.
     * @return - Indexes of two numbers that make up target, or empty array if none was found.
     */
    public static int[] twoSumBadSolution(int[] arr, int target){
        for(int i = 0; i < arr.length; i++){
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] + arr[j] == target) return new int[]{i,j};
            }
        }
        return new int[] {};
    }

    /**
     * Using hash map to calculate missing number for each number in arr.
     * If when running the array this number is found it will return the indexes of both numbers that make up target.
     * Good solution! | Time-Complexity:O(n) | Space-Complexity:O(n)
     * @param arr - Numbers to iterate on and search for two numbers that make up target.
     * @param target - Target number to calculate using two numbers from arr.
     * @return - Indexes of two numbers that make up target, or empty array if none was found.
     */
    public static int[] twoSumGoodSolution(int[] arr, int target){
        HashMap<Integer, Integer> optionalCombinations = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            int intToSearch = target - arr[i];
            if(optionalCombinations.containsKey(intToSearch)) return new int[] {optionalCombinations.get(intToSearch), i};
            else optionalCombinations.put(arr[i], i);
        }
        return new int[] {};
    }
    public static void main(String[] args) {
        System.out.println("Checking bad solution:");
        System.out.println(Arrays.toString(twoSumBadSolution(new int[]{1, 3, 5, 7, 9, 45}, 46))); //Expected [0, 5]
        System.out.println(Arrays.toString(twoSumBadSolution(new int[]{1, 3, 5, 7, 9, 11}, 21))); //Expected empty
        System.out.println(Arrays.toString(twoSumBadSolution(new int[]{1, 3, 5, 6, 9}, 12))); //Expected [1, 4]
        System.out.println("----------------------------------------------------------------");

        System.out.println("Checking good solution:");
        System.out.println(Arrays.toString(twoSumGoodSolution(new int[]{1, 3, 5, 7, 9, 45}, 46))); //Expected [0, 5]
        System.out.println(Arrays.toString(twoSumGoodSolution(new int[]{1, 3, 5, 7, 9, 11}, 21))); //Expected empty
        System.out.println(Arrays.toString(twoSumGoodSolution(new int[]{1, 3, 5, 6, 9}, 12))); //Expected [1, 4]
        System.out.println("----------------------------------------------------------------");
    }
}
