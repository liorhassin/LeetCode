package NeetCodeRoadmap.TwoPointers;

public class IsPalindrome {


    /**
     * This method is just an extra, in this LeetCode question strings are all lower case.
     * Time-Complexity O(n)
     * @param s - String to simplify and return without spaces and all lowercase.
     * @return desired string after manipulation.
     */
    public static String stringSimplify(String s){
        return s.replaceAll("[^a-zA-Z0-9]+", "").toLowerCase();
    }

    /**
     *
     * @param s
     * @return
     */
    public static boolean isPalindromeGoodSolution(String s){
        s = stringSimplify(s);
        int start = 0;
        int end = s.length()-1;
        while(start < end){
            if (!(s.charAt(start) == s.charAt(end))) return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Checking good solution:");
        System.out.println(isPalindromeGoodSolution("civic civic")); //Expected true
        System.out.println(isPalindromeGoodSolution("abcde")); //Expected false
        System.out.println(isPalindromeGoodSolution("madam")); //Expected true
        System.out.println(isPalindromeGoodSolution("test")); //Expected false
        System.out.println(isPalindromeGoodSolution("radar")); //Expected true
        System.out.println(isPalindromeGoodSolution("fail")); //Expected false
        System.out.println(isPalindromeGoodSolution("deified")); //Expected true
        System.out.println(isPalindromeGoodSolution("definition")); //Expected false
    }
}
