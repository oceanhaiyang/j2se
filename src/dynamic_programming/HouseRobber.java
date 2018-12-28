package dynamic_programming;

/**
 * Created by lhy on 2018/12/28.
 简单的动态规划问题，题目意思是计算数组中 不相邻数字最大之和。
 比如  [ 1, 3, 4, 5, 3, 2 ]  应返回 10 ， 3 + 5 + 2 = 10 。
 */
public class HouseRobber {
    public static int rob(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int[] result = new int[nums.length];//状态表 使用数组记录
        result[0] = nums[0];
        result[1] = Math.max(nums[0], nums[1]);

        for(int index=2; index < result.length; index++){
            result[index] = Math.max(nums[index] + result[index-2], result[index -1]);//递推式
        }

        return result[nums.length -1];
    }


    public static void main(String[] args){
        int[] nums={1,3,2,5,100};

        int result =  HouseRobber.rob(nums);

        System.out.println("最大金额是："+result);
    }
}