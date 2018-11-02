package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *借助hashmap和栈
 */
public class NextGreaterElementI {

    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        int[] A = {4,1,2};
        int[] B = {1,-1,4,5,6,2};
        int[] result = new NextGreaterElementI().nextGreaterElement(A, B);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        //辅助栈，存放待查找结果的元素，查找到的立即出栈
        Stack<Integer> stack = new Stack<>();
        //key存放元素，value存放找到的第一个大于它的值
        Map<Integer, Integer> map = new HashMap<>();
        //当栈顶元素大于当前元素时，入栈；当栈顶元素小于当前元素时，
        // 说明栈顶元素找到了第一个大于的值，出栈，然后继续出栈直到栈顶元素大于当前元素，将当前元素入栈。
        for (int i = 0; i < nums.length; i++) {
            while(!stack.isEmpty() && stack.peek() < nums[i]){
                map.put(stack.pop(), nums[i]);
            }
            stack.push(nums[i]);
        }
        //ans数组存放结果
        int[] ans = new int[findNums.length];
        //遍历findNums，在map中查找结果，不存在说明没有大于它的第一个元素，赋值为-1
        for (int i = 0; i < findNums.length; i++) {
            //map的getOrDefault方法
            ans[i] = map.getOrDefault(findNums[i], -1);
        }
        return ans;
    }

}
