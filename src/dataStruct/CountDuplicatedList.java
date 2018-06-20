package dataStruct;

import java.util.*;

public class CountDuplicatedList {

    public static void main(String[] args) {

        List<List<Integer>> lists = new ArrayList<>();


        for (int i = 0; i <5 ; i++) {
            List list = new ArrayList<Integer>();
            for (int j = 0; j <5 ; j++) {
                list.add((int) (Math.random() * 90 + 10));
            }
            lists.add(list);
        }

        Map map = new HashMap();

        for (Object temp : lists) {
            Object count = map.get(temp);
            map.put(temp, (count == null) ? 1 : (Integer) count + 1);
        }

        for (Object key : map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }

        /*System.out.println("无重复的数据");
        for (Object key : map.keySet()) {
            if (map.get(key).equals(1)) {
                System.out.println(key);
            }
        }*/

        /*System.out.println("重复的数据");
        for (Object key : map.keySet()) {
            if (!map.get(key).equals(1)) {
                System.out.println(key + ":" + map.get(key));
            }
        }*/


    }

}