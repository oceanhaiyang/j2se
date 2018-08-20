package thinking_java;

import java.util.*;

public class Test{
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");


       for(Map.Entry<String,String> entry:map.entrySet()){
           System.out.println(entry.getKey()+":"+entry.getValue());
       }



        //第三种：推荐，尤其是容量大时
        System.out.println("通过Map.entrySet遍历key和value");
        /*for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }*/

        ThreadLocal local = new ThreadLocal();
        local.set("faaf");
        Thread01 thread01 = new Thread01(local);
        thread01.start();
        System.out.println("- -- --"+" "+local.get());

    }
}