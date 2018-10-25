package array;

import java.util.Arrays;

/**
 * 我们找返回一个整数h，使得数组中至少h个元素值大小>=h，其n−h个元素值<h
 * */
public class HIndex {

    public static void main(String[] args) throws Exception{
        int[] A = {3, 0, 6, 1, 5};
        System.out.println(new HIndex().hIndex(A));
    }

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int res = 0;
        while (res < citations.length && citations[citations.length - 1 - res] > res) {
            res++;
        }
        return res;
    }

}