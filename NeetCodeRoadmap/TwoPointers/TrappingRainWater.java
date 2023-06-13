package NeetCodeRoadmap.TwoPointers;

public class TrappingRainWater {

    public static int trappingRainWaterGoodSolution(int[] height){
        if(height.length == 0) return 0;

        int startP = 0, endP = height.length-1, maxHeightLeft = height[0],
                maxHeightRight = height[height.length-1], result = 0;

        while(startP < endP){

            if(height[startP] <= height[endP]){
                startP++;
                maxHeightLeft = Math.max(maxHeightLeft, height[startP]);
                if(maxHeightLeft > height[startP]) result += maxHeightLeft - height[startP];
            }

            else {
                endP--;
                maxHeightRight = Math.max(maxHeightRight, height[endP]);
                if(maxHeightRight > height[endP]) result += maxHeightRight - height[endP];
            }
        }
        return result;
    }



    public static void main(String[] args) {
        System.out.println("Checking good solution:");
        System.out.println(trappingRainWaterGoodSolution(new int[]{4,2,0,3,2,5}));
        System.out.println(trappingRainWaterGoodSolution(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
