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
        if(s != null) return s.replaceAll(" ", "").toLowerCase();
        return null;
    }

    public static List<List<String>> groupAnagramsBadSolution(String[] strs){
        Map<Map<Character, Integer>, Integer> countingMap = new HashMap<>();
        List<List<String>> resultMatrix = new ArrayList<>();
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
        if(resultMatrix.size()>0){
            return resultMatrix;
        }
        return new ArrayList<>();
    }

    public static List<List<String>> groupAnagramsDecentSolution(String[] strs){
        Map<int[], Integer> countingMap = new HashMap<>();
        List<List<String>> resultMatrix = new ArrayList<>();
        for(String str: strs){
            int[] currentWordCounter = new int[26];
            Arrays.fill(currentWordCounter, 0);
            for(int i = 0; i < str.length(); i++){
                currentWordCounter[str.charAt(i)-'a']++;
            }
            if(!countingMap.containsKey(currentWordCounter)){
                countingMap.put(currentWordCounter, resultMatrix.size());
                resultMatrix.add(new ArrayList<>());
            }
            resultMatrix.get(countingMap.get(currentWordCounter)).add(str);
        }
        return resultMatrix;
    }

    public static void main(String[] args) {
        System.out.println("Checking decent solution:");
        System.out.println(groupAnagramsBadSolution(new String[]{"lior", "roil", "test", "fire", "a", "b", "rife"}));
        System.out.println(groupAnagramsBadSolution(new String[]{"lior", "roil", "cat", "atc", "c", "b"}));
        System.out.println("---------------------------------------------------------");

        System.out.println("Checking upgraded solution:");
        System.out.println(groupAnagramsDecentSolution(new String[]{"lior", "roil", "test", "fire", "a", "b", "rife"}));
        System.out.println(groupAnagramsDecentSolution(new String[]{"lior", "roil", "cat", "atc", "c", "b"}));
        System.out.println("---------------------------------------------------------");
    }
}
