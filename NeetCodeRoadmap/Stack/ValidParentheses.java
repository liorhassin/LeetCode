package NeetCodeRoadmap.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    /**
     * Using a stack data structure, Adding to stack when encountering opening parentheses.
     * Removing when encountering closing parentheses.
     * Good solution! | Time-Complexity: O(n) | Space-Complexity: O(n)
     * @param s - Given string to validate parentheses.
     * @return boolean - if stack is empty meaning parentheses are valid or not.
     */
    public static boolean validParenthesesGoodSolution(String s){
        Map<Character, Character> parenthesesMatch = new HashMap<>();
        parenthesesMatch.put('(',')');
        parenthesesMatch.put('{','}');
        parenthesesMatch.put('[',']');

        Stack<Character> parenthesesTracker = new Stack<>();
        for(Character c : s.toCharArray()){
            if(parenthesesMatch.containsKey(c)) parenthesesTracker.add(c);
            else if (parenthesesTracker.empty()) return false;
            else if (!parenthesesMatch.get(parenthesesTracker.pop()).equals(c)) return false;
        }
        return parenthesesTracker.empty();
    }

    public static void main(String[] args) {
        System.out.println("Checking good solution:");
        System.out.println(validParenthesesGoodSolution("()[]{}"));
        System.out.println(validParenthesesGoodSolution("([)]"));
        System.out.println(validParenthesesGoodSolution(""));
        System.out.println(validParenthesesGoodSolution("("));
        System.out.println(validParenthesesGoodSolution("([{}])"));
        System.out.println(validParenthesesGoodSolution("]"));
    }
}
