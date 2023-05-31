package NeetCodeRoadmap.ArraysAndHashing;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    /**
     * Using 2 running products and 2 for loops to build the left and right product of given array.
     * First build left running product and save the iteration to result Array.
     * Update result array using right product and change right product with original array.
     * Good solution! | Time-Complexity: O(2n) = O(n) | Space-Complexity: O(n)
     * @param nums - given array to calculate the product of, except for self number.
     * @return - new array with product of each index.
     */
    public static int[] ProductOfArrayExceptSelfGoodSolution(int[] nums){
        int leftProduct =1; //Initialize to 1 (multiply base).
        int rightProduct = 1; //Initialize to 1 (multiply base).
        int[] resultProduct = new int[nums.length];

        //Calculating running left product
        for (int i = 0; i < nums.length; i++) {
            resultProduct[i] = leftProduct;
            leftProduct = leftProduct * nums[i]; //Keeping track of running left product.
        }

        //Calculating right product
        for (int i = nums.length - 1; i >= 0; i--) {
            resultProduct[i] = rightProduct * resultProduct[i];
            rightProduct = rightProduct * nums[i]; //Following running right product while keeping track of left calculation.
        }

        return resultProduct;
    }

    public static void main(String[] args) {
        System.out.println("Checking good solution:");
        System.out.println(Arrays.toString(ProductOfArrayExceptSelfGoodSolution(
                new int[]{1, 2, 3, 4}))); //Expected [24,12,8,6]
        System.out.println(Arrays.toString(ProductOfArrayExceptSelfGoodSolution(
                new int[]{0, -1, 1, 6}))); //Expected [-6,0,0,0]
        System.out.println(Arrays.toString(ProductOfArrayExceptSelfGoodSolution(
                new int[]{0, 0, 1, 0}))); //Expected [0,0,0,0]
        System.out.println(Arrays.toString(ProductOfArrayExceptSelfGoodSolution(
                new int[]{1, 3, 5, -7}))); //Expected [-105, -35, -21, 15]
    }
}
