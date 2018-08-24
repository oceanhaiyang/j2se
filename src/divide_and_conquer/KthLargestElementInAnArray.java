package divide_and_conquer;

/**
 * 找第k个大的数
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KthLargestElementInAnArray {
    /**
     * Main method
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        int[] nums = {3, 2, 1, 5, 6, 4};

        System.out.println(new KthLargestElementInAnArray().findKthLargest(nums, 2));
    }

    private int findKthLargest(int[] nums, int k) {
        return solve(nums, 0, nums.length - 1, k);
    }

    private int solve(int[] nums, int pIndex, int end, int k) {
        int pivot = nums[end];
        int temp;
        int start = pIndex;
        for (int i = pIndex; i < end; i++) {
            if (nums[i] <= pivot) {
                temp = nums[i];
                nums[i] = nums[pIndex];
                nums[pIndex] = temp;
                pIndex += 1;
            }
        }
        temp = nums[pIndex];
        nums[pIndex] = nums[end];
        nums[end] = temp;

        int pos = (end - pIndex) + 1;
        if (pos == k) return nums[pIndex];
        else if (pos > k) {
            return solve(nums, pIndex + 1, end, k);
        } else {
            return solve(nums, start, pIndex - 1, k - pos);
        }
    }

}