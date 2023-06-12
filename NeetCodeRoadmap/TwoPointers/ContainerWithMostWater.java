package NeetCodeRoadmap.TwoPointers;

public class ContainerWithMostWater {


    /**
     * Uses 2 pointers to iterate through the array of heights and check if minimum height of pointers times the
     * length of the sub array can container more than already calculated maximum area.
     * Pointers move left or right depending on their current height, we want to maintain the highest pole for as
     * long as we possibly can.
     * Good solution! | Time-Complexity: O(n) | Space-Complexity: Constant(O(1))
     * @param heights - given array to iterate and check for maximum area.
     * @return The maximum area found within heights array.
     */
    public static int containerWithMostWaterGoodSolution(int[] heights){
        if(heights.length == 0 || heights.length == 1){
            return 0;
        }
        int startP = 0;
        int endP = heights.length-1;
        int result = 0;
        while(startP < endP){
            //result = Math.max(result, (Math.min(heights[startP], heights[endP])*(endP-startP))); //Removed for better time complexity(4ms -> 2ms)
            if(heights[startP] <= heights[endP]) {
                int tempResult = heights[startP] * (endP-startP);
                if(tempResult > result) result = tempResult;
                startP++;
            }
            else {
                int tempResult = heights[endP] * (endP-startP);
                if(tempResult > result) result = tempResult;
                endP--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Checking good solution:");
        System.out.println(containerWithMostWaterGoodSolution(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
