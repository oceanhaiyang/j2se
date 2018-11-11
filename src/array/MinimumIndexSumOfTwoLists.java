package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**

 */
public class MinimumIndexSumOfTwoLists {
    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) throws Exception{
        String[] A1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] A2 = {"Tapioca Express", "Shogun", "Burger King"};
        String[] ans = new MinimumIndexSumOfTwoLists().findRestaurant(A1, A2);
        for(String s : ans){
            System.out.println(s);
        }
    }

   /* public String[] findRestaurant(String[] list1, String[] list2) {
        int min = Integer.MAX_VALUE;
        List<String> result = new ArrayList<>();
        if(list2.length == 0) return new String[0];
        Map<String, Integer> index = new HashMap<>();
        for(int i = 0; i < list2.length; i ++){
            index.put(list2[i], i);
        }
        for(int i = 0; i < list1.length; i ++){
            String s = list1[i];
            if(index.containsKey(s)){
                int sum = i + index.get(s);
                min = Math.min(min, sum);
            }
        }

        for(int i = 0; i < list1.length; i ++){
            String s = list1[i];
            if(index.containsKey(s)){
                int sum = i + index.get(s);
                if(sum == min){
                    result.add(s);
                }
            }
        }
        String[] resArr = new String[result.size()];
        result.toArray(resArr);
        return resArr;
    }*/


        public String[] findRestaurant(String[] list1, String[] list2) {
            HashMap<String,Integer> map=new HashMap<String,Integer>();
            List<String> list=new ArrayList<String>();
            int index=0;
            //将list1元素存入哈希表
            for(int i=0;i<list1.length;i++) {
                map.put(list1[i], i+1);
            }
            //查看list2中的元素在哈希表是否存在
            for(int i=0;i<list2.length;i++) {
                if(map.containsKey(list2[i])) {
                    if(index==0) {   //第一次找到相同的
                        list.add(list2[i]);
                        index=i+map.get(list2[i]);
                    }else if(index==i+map.get(list2[i])) {  //找到相同的，且索引和相同
                        list.add(list2[i]);
                    }else if(index>i+map.get(list2[i])) {    //找到相同的，索引和小于原来的索引和
                        list.clear();
                        list.add(list2[i]);
                        index=i+map.get(list2[i]);
                    }
                }
            }
            int len=list.size();
            String s[]=new String[len];
            int i=0;
            for(String str:list) {
                s[i]=str;
                i++;
            }
            return s;
        }


}