package NeetCodeRoadmap.ArraysAndHashing;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class KMostFrequentNumbers {


    /**
     * Using a map to count numbers, after counting sorts the array and returns the K most frequent numbers.
     * Decent solution! | Time-Complexity: O(nlog(n)) | Space-Complexity: O(n)
     * @param numbers - Given array to find k most frequent numbers on.
     * @return new array with the k most frequent numbers.
     */
    public static int[] kMostFrequentNumbersDecentSolution(int[] numbers, int k){
        int[] result = new int[k];
        Map<Integer, Integer> countingMap = new HashMap<>();
        for(Integer currentNumber : numbers){
            countingMap.put(currentNumber, countingMap.getOrDefault(currentNumber, 0)+1);
        }
        List<Entry<Integer, Integer>> entrySet = new ArrayList<>(countingMap.entrySet());
        entrySet.sort(Entry.comparingByValue());
        for(int i = 0; i < k; i++){
            result[i] = entrySet.get(entrySet.size()-1-i).getKey();
        }
        return result;
    }

    /**
     * Using a map to count numbers, while counting update another map which maps from count to a list of all numbers
     * that has the same count.
     * Good solution! | Time-Complexity: O(n) + O(k) = O(n) *K<=n | Space-Complexity: O(n)
     * @param numbers
     * @return
     */
    public static int[] kMostFrequentNumbersGoodSolution(int[] numbers, int k){
        Map<Integer, Integer> countingMap = new HashMap<>();
        Map<Integer, List<Integer>> resultMap = new HashMap<>();
        Set<Integer> takenNumbers = new HashSet<>();
        List<Integer> finalResult = new ArrayList<>();
        int maxCount = 0;
        for(Integer currentNum : numbers){
            countingMap.put(currentNum, countingMap.getOrDefault(currentNum, 0)+1);
            if(!resultMap.containsKey(countingMap.get(currentNum))){
                resultMap.put(countingMap.get(currentNum), new ArrayList<>());
                maxCount++;
            }
            resultMap.get(countingMap.get(currentNum)).add(currentNum);
        }

        while(k > 0){
            ArrayList<Integer> currentList = (ArrayList<Integer>) resultMap.remove(maxCount);
            maxCount--;
            while(k > 0 && !currentList.isEmpty()){
                int currentNum = currentList.remove(currentList.size()-1);
                if(!takenNumbers.contains(currentNum)){
                    finalResult.add(currentNum);
                    takenNumbers.add(currentNum);
                    k--;
                }
            }
        }

        return finalResult.stream().mapToInt(x->x).toArray();
    }

    /**
     * Using a map to count numbers, while counting updates a List of lists.
     * Main list index acts as the count and inside list keeps track of numbers with that count.
     * Upgraded version because list is faster to work on and with map solution we need to pull all values and then
     * work our way to build the K elements, With list we just iterate on indexes until k elements was found.
     * Upgraded solution! | Time-Complexity: O(n) | Space-Complexity: O(n)
     * @param numbers
     * @return
     */
    public static int[] kMostFrequentNumbersUpgradedSolution(int[] numbers, int k){


        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println("Checking decent solution:");
        System.out.println(Arrays.toString(kMostFrequentNumbersDecentSolution(
                new int[]{1, 1, 1, 2, 2, 3}, 2))); //Expected [1,2]
        System.out.println(Arrays.toString(kMostFrequentNumbersDecentSolution(
                new int[]{1, 1, 1, 2, 2, 3}, 3))); //Expected [1,2,3]
        System.out.println(Arrays.toString(kMostFrequentNumbersDecentSolution(
                new int[]{1, 1, 2, 2, 2, 3, 3, 3, 3, 5, 5, 5, 5, 5}, 2))); //Expected [5,3]
        System.out.println(Arrays.toString(kMostFrequentNumbersDecentSolution(
                new int[]{1, 2, 3, 1, 1, 4, 5, 6, 1, 2, 3, 1, 1, 2, 2, 2}, 2))); //Expected [1,2]
        System.out.println(Arrays.toString(kMostFrequentNumbersDecentSolution(
                new int[]{1}, 1))); //Expected [1]
        System.out.println("----------------------------------------------------------------");

        System.out.println("Checking good solution:");
        System.out.println(Arrays.toString(kMostFrequentNumbersGoodSolution(
                new int[]{1, 1, 1, 2, 2, 3}, 2))); //Expected [1,2]
        System.out.println(Arrays.toString(kMostFrequentNumbersGoodSolution(
                new int[]{1, 1, 1, 2, 2, 3}, 3))); //Expected [1,2,3]
        System.out.println(Arrays.toString(kMostFrequentNumbersGoodSolution(
                new int[]{1, 1, 2, 2, 2, 3, 3, 3, 3, 5, 5, 5, 5, 5}, 2))); //Expected [5,3]
        System.out.println(Arrays.toString(kMostFrequentNumbersGoodSolution(
                new int[]{1, 2, 3, 1, 1, 4, 5, 6, 1, 2, 3, 1, 1, 2, 2, 2}, 2))); //Expected [1,2]
        System.out.println(Arrays.toString(kMostFrequentNumbersGoodSolution(
                new int[]{1}, 1))); //Expected [1]
        System.out.println("----------------------------------------------------------------");


        System.out.println("Checking upgraded solution:");
        System.out.println(Arrays.toString(kMostFrequentNumbersUpgradedSolution(
                new int[]{1, 1, 1, 2, 2, 3}, 2))); //Expected [1,2]
        System.out.println(Arrays.toString(kMostFrequentNumbersUpgradedSolution(
                new int[]{1, 1, 1, 2, 2, 3}, 3))); //Expected [1,2,3]
        System.out.println(Arrays.toString(kMostFrequentNumbersUpgradedSolution(
                new int[]{1, 1, 2, 2, 2, 3, 3, 3, 3, 5, 5, 5, 5, 5}, 2))); //Expected [5,3]
        System.out.println(Arrays.toString(kMostFrequentNumbersUpgradedSolution(
                new int[]{1, 2, 3, 1, 1, 4, 5, 6, 1, 2, 3, 1, 1, 2, 2, 2}, 2))); //Expected [1,2]
        System.out.println(Arrays.toString(kMostFrequentNumbersUpgradedSolution(
                new int[]{1}, 1))); //Expected [1]
        System.out.println("----------------------------------------------------------------");
    }
}
