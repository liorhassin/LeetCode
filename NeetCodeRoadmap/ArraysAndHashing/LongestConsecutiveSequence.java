package NeetCodeRoadmap.ArraysAndHashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    /**
     * Sorts array and then iterates one more time to calculate/count the longest consecutive sequence.
     * Decent solution! | Time-Complexity: O(nlog(n)) | Space-Complexity: O(n)
     * @param nums
     * @return
     */
    public static int longestConsecutiveSequenceDecentSolution(int[] nums){
        if(nums.length == 0) return 0;
        int lcsLength = 1;
        int currentLength = 1;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            int currentNumber = nums[i];
            if(nums[i+1] == currentNumber + 1) currentLength++;
            else{
                lcsLength = Math.max(lcsLength, currentLength);
                currentLength = 1;
            }
        }
        if(currentLength != 1) return currentLength;
        return lcsLength;
    }

    /**
     * Initiate a Set for all numbers found in array. And iterate array one more time to calculate
     * the longest consecutive sequence. To keep the Time-Complexity: O(n) added an if statement to check if previous
     * number exists in set, if so skip calculation for current number.
     * Explanation - If previous number is already found within set.
     * Example current number is 4 and 3 is within the numberSet. Then it means we don't need to calculate subSequence length for 4.
     * When 3 turns comes up the algorithm will catch 4 and all the rest for the biggest sequence length.
     * Decent solution! | Time-Complexity: O(n) | Space-Complexity: O(n)
     * @param nums
     * @return
     */
    public static int longestConsecutiveSequenceGoodSolution(int[] nums){
        if(nums.length == 0) return 0;
        Set<Integer> uniqueNumbers = new HashSet<>();
        int lcsLength = 1;
        for(Integer currentNumber : nums) uniqueNumbers.add(currentNumber);
        for(Integer currentNumber : nums){
            if(!uniqueNumbers.contains(currentNumber-1)){
                int currentCounter = 1;
                while(uniqueNumbers.contains(currentNumber+1)){
                    currentCounter++;
                    currentNumber++;
                }
                lcsLength = Math.max(lcsLength, currentCounter);
            }
        }
        return lcsLength;
    }

    public static void main(String[] args) {
        System.out.println("Checking decent solution:");
        System.out.println("Length returned from test: " +
                longestConsecutiveSequenceDecentSolution(new int[]{0,4,0,1,3,2})); //Expected 5
        System.out.println("Length returned from test: " +
                longestConsecutiveSequenceDecentSolution(new int[]{1,4,7,9,2,3,5})); //Expected 5
        System.out.println("Length returned from test: " +
                longestConsecutiveSequenceDecentSolution(new int[]{})); //Expected 0
        System.out.println("Length returned from test: " +
                longestConsecutiveSequenceDecentSolution(new int[]{1,8,2,9,3,10,4,5,6,7})); //Expected 10

        System.out.println("----------------------------------------------------------------");

        System.out.println("Checking good solution:");
        System.out.println("Length returned from test: " +
                longestConsecutiveSequenceGoodSolution(new int[]{0,4,0,1,3,2})); //Expected 5
        System.out.println("Length returned from test: " +
                longestConsecutiveSequenceGoodSolution(new int[]{1,4,7,9,2,3,5})); //Expected 5
        System.out.println("Length returned from test: " +
                longestConsecutiveSequenceGoodSolution(new int[]{})); //Expected 0
        System.out.println("Length returned from test: " +
                longestConsecutiveSequenceGoodSolution(new int[]{1,8,2,9,3,10,4,5,6,7})); //Expected 10
    }
}
