package thinking_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lhy on 2018/6/28.
 */
public class UniqueArray {
    public static void main(String[] args){
        //数组去重方法一。。两层for循环，hashset,indexof
        String[] array = {"a","b","c","c","d","e","e","e","a"};
        List<String> result = new ArrayList<>();
        boolean flag;
        for(int i=0;i<array.length;i++){
            flag = false;
            for(int j=0;j<result.size();j++){
                if(array[i].equals(result.get(j))){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                result.add(array[i]);
            }
        }
        String[] arrayResult = (String[]) result.toArray(new String[result.size()]);
        System.out.println(Arrays.toString(arrayResult));

        //数组去重方法二
        /*String[] array = {"a","b","c","c","d","e","e","e","a"};
        List<String> list = new ArrayList<>();
        list.add(array[0]);
        for(int i=1;i<array.length;i++){
            //如果在list中没找到数组中的元素，则添加
            if(list.toString().indexOf(array[i]) == -1){
                list.add(array[i]);
            }
        }
        String[] arrayResult = (String[]) list.toArray(new String[list.size()]);
        System.out.println(Arrays.toString(arrayResult));*/
    }
}
