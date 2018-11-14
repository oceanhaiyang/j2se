package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 一张卡有正反两面,两面都有数字,现在可以随便翻卡,
 如果某一个卡的背面数字在所有卡的正面都没有出现过的话,
 这个数字就是'good',求最小的满足这种性质的数字。
 */
public class CardFilipGame {

    public static void main(String[] args) {
       // fronts = [1,2,4,4,7], backs = [1,3,4,1,3]
        int [] fronts = {1,2,4,4,7};
        int [] backs = {1,3,4,1,3};
        int number = new CardFilipGame().flipgame(fronts,backs);
        System.out.print(number);
    }

    public int flipgame(int[] fronts, int[] backs) {
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < fronts.length; i ++){
            numbers.add(fronts[i]);
            numbers.add(backs[i]);
        }
        Collections.sort(numbers);
        for(int n : numbers){
            boolean success = true;
            for(int i = 0; i < fronts.length; i ++){
                if(n == fronts[i] && n == backs[i]){
                    success = false;
                    break;
                }
            }
            if(success){
                return n;
            }
        }
        return 0;
    }

}
