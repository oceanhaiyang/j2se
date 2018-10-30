package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum
 * equals to k.
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * Note:
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 * Solution: O(n) Maintain a hash-map of prefix sum and its count and check for range sum for each element.
 */
public class SubarraySumEqualsK {

    /**
     * Main method
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        int[] A = {1, 2, 1, -2, 3, -1, -1};
        System.out.println(new SubarraySumEqualsK().subarraySum(A, 2));
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> data = new HashMap<>();
        data.put(0, 1);
        int sum = 0;
        int re = 0;
        for (int n : nums) {
            sum += n;
            re += data.getOrDefault(sum - k, 0);
            data.put(sum, data.getOrDefault(sum, 0) + 1);
        }
        return re;

    }
}