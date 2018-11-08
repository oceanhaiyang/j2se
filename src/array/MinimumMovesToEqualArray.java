package array;

import java.util.Arrays;

/**
 */
public class MinimumMovesToEqualArray {
    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        int[] A = {1, 2, 3,4};
        System.out.println(new MinimumMovesToEqualArray().minMoves2(A));
    }
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0,j = nums.length - 1;
        int count = 0;
        while(i < j){
            count += nums[j--] - nums[i++];
        }
        return count;
    }
}