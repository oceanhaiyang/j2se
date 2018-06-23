package dataStruct;

import java.util.*;

/*
 * 本题题意：给出一个数组  从数组中找到四个数字  使得其和为目标值  给出所有不重复的结果
 *
 *  For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
 *
 * 解题思路：用hashset存储不重复的元素，然后遍历数组，第一个元素从头往后遍历，第二个元素从后往前遍历，中间的两个元素往中间挤压式寻找。
 */
public class FourSum {

    public static List<List<Integer>> fourSum(int[] num, int target){
        //hashset用于存储不重复的元素
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
        //用于记录答案
        List<List<Integer>> answer = new ArrayList<List<Integer>>();

        int numSize = num.length;
        if(numSize < 4) return answer;
        //对数组进行排序
        Arrays.sort(num);

        //遍历方式：第一个元素从前往后
        for(int i = 0; i < numSize-3; i++) {
            //第二个元素，从后往前  注意这个范围
            for(int k = numSize-1; k > i+2; k--) {
                int ab = num[i] + num[k];
                int c = target-ab;
                int m = i+1;
                int n = k-1;
                //后两个元素还是采用向中间挤压的方式
                while(m < n) {
                    int sum = num[m] + num[n];
                    if(sum == c) {
                        ArrayList elem = new ArrayList();
                        elem.add(num[i]);
                        elem.add(num[m]);
                        elem.add(num[n]);
                        elem.add(num[k]);
                        set.add(elem);
                        m++;
                        n--;
                    }
                    else if(sum < c) {
                        m++;
                    }
                    else n--;
                }
            }
        }

        //  new ArrayList(HashSet)
        return new ArrayList<List<Integer>>(set);
    }

    public static void main(String[] args){
        int [] a ={1 ,0, -1, 0, -2, 2};
        Set sets = new HashSet();
        List<List<Integer>> lists = FourSum.fourSum(a,0);
        Iterator<List<Integer>> iterators = lists.iterator();
        while (iterators.hasNext()){
            List<Integer> list =  iterators.next();
            System.out.println(list.toString());
        }
    }
}
