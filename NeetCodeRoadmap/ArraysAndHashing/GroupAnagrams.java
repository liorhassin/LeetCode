package NeetCodeRoadmap.ArraysAndHashing;

import java.util.*;

public class GroupAnagrams {

    /**
     * This method is just an extra, in this LeetCode question strings are all lower case.
     * Time-Complexity O(n)
     * @param s - String to simplify and return without spaces and all lowercase.
     * @return desired string after manipulation.
     */
    public static String stringSimplify(String s){
        return s.replaceAll(" ", "").toLowerCase();
    }

    public static List<List<String>> groupAnagramsBadSolution(String[] strs){
        List<List<String>> resultMatrix = new ArrayList<>();
        if(strs.length == 0) return resultMatrix;
        for(int i = 0; i < strs.length; i++) strs[i] = stringSimplify(strs[i]);
        Map<Map<Character, Integer>, Integer> countingMap = new HashMap<>();
        for(String str : strs){
            Map<Character, Integer> currentWordCounter = new HashMap<>();
            for(int i = 0; i < str.length(); i++){
                currentWordCounter.put(str.charAt(i), currentWordCounter.getOrDefault(str.charAt(i), 0)+1);
            }
            if(!countingMap.containsKey(currentWordCounter)){
                countingMap.put(currentWordCounter, resultMatrix.size());
                resultMatrix.add(new ArrayList<>());
            }
            resultMatrix.get(countingMap.get(currentWordCounter)).add(str);
        }
        return resultMatrix;
    }

<<<<<<< HEAD
    public static List<List<String>> groupAnagramsGoodSolution(String[] strs){
        Map<int[], Integer> countingMap = new HashMap<>();
=======
    public static List<List<String>> groupAnagramsDecentSolution(String[] strs){
>>>>>>> cadee4845b434bc708ea92db52b74ba60972717a
        List<List<String>> resultMatrix = new ArrayList<>();
        if(strs.length == 0) return resultMatrix;
        for(int i = 0; i < strs.length; i++) strs[i] = stringSimplify(strs[i]);
        Map<String, List<String>> countingMap = new HashMap<>();
        for(String str: strs){
            int[] currentWordCounter = new int[26];
            for(int i = 0; i < str.length(); i++){
                currentWordCounter[str.charAt(i)-'a']++;
            }
            String arrayToKey = Arrays.toString(currentWordCounter);
            if(!countingMap.containsKey(arrayToKey)){
                countingMap.put(arrayToKey, new ArrayList<>());
            }
            countingMap.get(arrayToKey).add(str);
        }
        resultMatrix.addAll(countingMap.values());
        return resultMatrix;
    }

    public static void main(String[] args) {
        System.out.println("Checking decent solution:");
        System.out.println(groupAnagramsBadSolution(new String[]{"lior", "roil", "test", "fire", "a", "b", "rife"}));
        System.out.println(groupAnagramsBadSolution(new String[]{"lior", "roil", "cat", "atc", "c", "b"}));
        System.out.println("---------------------------------------------------------");

        System.out.println("Checking upgraded solution:");
        System.out.println(groupAnagramsGoodSolution(new String[]{"lior", "roil", "test", "fire", "a", "b", "rife"}));
        System.out.println(groupAnagramsGoodSolution(new String[]{"lior", "roil", "cat", "atc", "c", "b"}));
        System.out.println("---------------------------------------------------------");
    }
}
