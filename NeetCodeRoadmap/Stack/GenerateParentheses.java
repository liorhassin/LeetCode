package NeetCodeRoadmap.Stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {

    List<String> result = new ArrayList<>();

    public List<String> generateParenthesesRecursiveSolution(int n){
        recursiveHelper( 0, 0, n, "");
        return result;
    }

    public void recursiveHelper(int opening, int closing, int n, String newValidCombination){
        if(closing == n){
            result.add(newValidCombination);
            return;
        }
        if(opening < n){
            recursiveHelper(opening+1, closing, n, newValidCombination+"(");
        }
        if(closing < opening){
            recursiveHelper(opening, closing+1, n, newValidCombination + ")");
        }
    }

    public void rec(int n){ //n = 1
        if(n == 4){
            System.out.println(n);
            return;
        }
        rec(n+1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        System.out.println(generateParentheses.generateParenthesesRecursiveSolution(3));
    }
}
