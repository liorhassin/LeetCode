package NeetCodeRoadmap.ArraysAndHashing;

import java.util.*;

public class ValidAnagram {

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

    /**
     * Saves indexes of t string that were equal to a char in s string.
     * When double-loop ends if Set size is equal to strings len then it is an Anagram.
     * Bad solution! | Time-Complexity: O(n^2) | Space-Complexity: O(n)
     * @param s - first string to compare.
     * @param t - second string to compare.
     * @return if s and t are anagrams.
     */
    public static boolean validAnagramBadSolution(String s, String t){
        s = stringSimplify(s);
        t = stringSimplify(t);
        if(s.length() != t.length()) return false;
        Set<Integer> takenIndexes = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < s.length(); j++){
                if(!takenIndexes.contains(j)){
                    if(s.charAt(i) == t.charAt(j)) takenIndexes.add(j);
                }
            }
        }
        return takenIndexes.size() == s.length();
    }

    /**
     * Sorts both strings in alphabetic order and runs a for loop to check if they are equal.
     * Decent solution! | Time-Complexity:O(nlog(n)) | Space-Complexity: O(n)
     * @param s - first string to compare.
     * @param t - second string to compare.
     * @return if s and t are anagrams.
     */
    public static boolean validAnagramDecentSolution(String s, String t){
        s = stringSimplify(s);
        t = stringSimplify(t);
        if(s.length() != t.length()) return false;

        char[] sToChars = s.toCharArray();
        char[] tToChars = t.toCharArray();
        Arrays.sort(sToChars);
        Arrays.sort(tToChars);

        for(int i = 0; i < sToChars.length; i++){
            if(sToChars[i] != tToChars[i]) return false;
        }

        return true;
    }

    /**
     * Counter characters for each string, s string ++ the counter and t string -- the counter.
     * If all counters for the letters are equal to 0 at the end they are anagrams.
     * Good solution! | Time-Complexity: O(n) | Space-Complexity: O(1) map-size can only
     *                                                                  reach 26 keys(fixed to english alphabet)
     * -! Possible upgrade will be to change from map to array, since it is fixed to size 26. Easy to count/manipulate.
     * @param s - first string to compare.
     * @param t - second string to compare.
     * @return if s and t are anagrams.
     */
    public static boolean validAnagramGoodSolution(String s, String t){
        s = stringSimplify(s);
        t = stringSimplify(t);
        if(s.length() != t.length()) return false;
        Map<Character, Integer> countingMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            countingMap.put(s.charAt(i), countingMap.getOrDefault(s.charAt(i), 0)+1);
            countingMap.put(t.charAt(i), countingMap.getOrDefault(t.charAt(i), 0)-1);
        }
        for(Character key: countingMap.keySet()){
            if(countingMap.get(key) != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println("Checking bad solution:");
        System.out.println(validAnagramBadSolution("Lior  ", "roil")); //Expected true
        System.out.println(validAnagramBadSolution("broken", "token")); //Expected false
        System.out.println(validAnagramBadSolution("New York Times   ", "monkeys write")); //Expected true
        System.out.println(validAnagramBadSolution("triple", "double")); //Expected false
        System.out.println(validAnagramBadSolution("listen", "silent")); //Expected true
        System.out.println("----------------------------------------------------------------");

        System.out.println("Checking decent solution:");
        System.out.println(validAnagramDecentSolution("Lior", "roil")); //Expected true
        System.out.println(validAnagramDecentSolution("broken", "token")); //Expected false
        System.out.println(validAnagramDecentSolution("New York Times   ", "monkeyswrite")); //Expected true
        System.out.println(validAnagramDecentSolution("triple", "double")); //Expected false
        System.out.println(validAnagramDecentSolution("listen", "silent")); //Expected true
        System.out.println("----------------------------------------------------------------");


        System.out.println("Checking good solution:");
        System.out.println(validAnagramGoodSolution("Lior", "roil")); //Expected true
        System.out.println(validAnagramGoodSolution("broken", "token")); //Expected false
        System.out.println(validAnagramGoodSolution("New York Times   ", "monkeyswrite")); //Expected true
        System.out.println(validAnagramGoodSolution("triple", "double")); //Expected false
        System.out.println(validAnagramGoodSolution("listen", "silent")); //Expected true
        System.out.println("----------------------------------------------------------------");
    }
}
