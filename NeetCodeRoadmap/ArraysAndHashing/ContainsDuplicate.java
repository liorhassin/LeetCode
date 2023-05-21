package NeetCodeRoadmap.ArraysAndHashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    /**
     * Using double for-loop to iterate the array for duplicates.
     * Bad solution! | Time-Complexity: O(n^2) | Space-Complexity: None
     * @param arr - Given array to check for duplicates
     * @return - true if found duplicates otherwise false.
     */
    public static boolean containsDuplicateBadSolution(int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                if(arr[i] == arr[j]) return true;
            }
        }
        return false;
    }

    /**
     * Sorts given array and check neighbours for duplicates.
     * Decent solution! | Time-Complexity: O(nlog(n)) | Space-Complexity: O(n)
     * @param arr - Given array to check for duplicates
     * @return - true if found duplicates otherwise false.
     */
    public static boolean containsDuplicateDecentSolution(int[] arr){
        int[] newSorted = Arrays.stream(arr).sorted().toArray();
        for(int i = 0; i < newSorted.length-1; i++){
            if(newSorted[i] == newSorted[i+1]) return true;
        }
        return false;
    }

    /**
     * Using Hashset to keep track of which numbers were found while iterating the array.
     * Good solution! | Time-Complexity: O(n) | Space-Complexity: O(n)
     * @param arr - Given array to check for duplicates
     * @return - true if found duplicates otherwise false.
     */
    public static boolean containsDuplicateGoodSolution(int[] arr){
        Set<Integer> knownNumbers = new HashSet<>();
        for (int j : arr) {
            if (knownNumbers.contains(j)) return true;
            else knownNumbers.add(j);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Checking bad solution:");
        System.out.println(containsDuplicateBadSolution(new int[]{1, 2, 3, 4})); //Expected false
        System.out.println(containsDuplicateBadSolution(new int[]{1, 2, 1, 4})); //Expected true
        System.out.println(containsDuplicateBadSolution(new int[]{1})); //Expected false
        System.out.println(containsDuplicateBadSolution(new int[]{1, 9, 7, 5, 3, 1})); //Expected true
        System.out.println("----------------------------------------------------------------");

        System.out.println("Checking decent solution:");
        System.out.println(containsDuplicateDecentSolution(new int[]{1, 2, 3, 4})); //Expected false
        System.out.println(containsDuplicateDecentSolution(new int[]{1, 2, 1, 4})); //Expected true
        System.out.println(containsDuplicateDecentSolution(new int[]{1})); //Expected false
        System.out.println(containsDuplicateDecentSolution(new int[]{1, 9, 7, 5, 3, 1})); //Expected true
        System.out.println("----------------------------------------------------------------");


        System.out.println("Checking good solution:");
        System.out.println(containsDuplicateGoodSolution(new int[]{1, 2, 3, 4})); //Expected false
        System.out.println(containsDuplicateGoodSolution(new int[]{1, 2, 1, 4})); //Expected true
        System.out.println(containsDuplicateGoodSolution(new int[]{1})); //Expected false
        System.out.println(containsDuplicateGoodSolution(new int[]{1, 9, 7, 5, 3, 1})); //Expected true
        System.out.println("----------------------------------------------------------------");
    }
}
