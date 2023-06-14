package NeetCodeRoadmap.BinarySearch;

public class BinarySearch {

    public static int binarySearchGoodSolution(int[] nums, int target){
        int startP = 0;
        int endP = nums.length-1;

        while(startP <= endP){
            int currentMidPoint = (endP + startP) / 2;
            if(nums[currentMidPoint] == target) return currentMidPoint;
            else if(nums[currentMidPoint] < target) startP = currentMidPoint+1;
            else endP = currentMidPoint-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Checking good solution:");
        System.out.println(binarySearchGoodSolution(new int[]{-1,0,3,5,9,12,14,15,16,17,18,19,21,22,23,24,25,26}, 23));
        System.out.println(binarySearchGoodSolution(new int[]{-1,0,3,5,9,12}, 2));
        System.out.println(binarySearchGoodSolution(new int[]{-1,0,3,5,9,12}, 9));
    }
}
