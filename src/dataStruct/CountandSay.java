package dataStruct;


/**
 * 本题题意：给出一个字符串，然后读取这个字符串，把数字以及出现的次数读取出来。
 * <p>
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * <p>
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * <p>
 * 给出n,求出第n个字符串是多少。
 * <p>
 * 解题思路：通过递归调用的方式，获取下一轮的结果，然后读取出下一轮作为当前的结果
 */
public class CountandSay {

    public static String countAndSay(int n) {
        //边界条件
        if (n == 1) {
            return "1";
        }

        //记录本轮结果
        String result = "";
        String preS = countAndSay(n - 1);
        //初始化两个值，记录住第一个字符以及出现次数
        String pre = preS.substring(0, 1);
        int count = 1;
        for (int i = 1; i < preS.length(); i++) {
            //循环遍历字符串   判断当前字符是否和前面的字符相等
            String current = preS.substring(i, i + 1);
            if (current.equals(pre)) {
                count++;
            } else {
                //不相等的时候，加上这个字符
                result += String.valueOf(count) + pre;
                pre = current;
                count = 1;
            }
        }
        result += String.valueOf(count) + pre;
        return result;
    }

    public static void main(String[] args) {
        String string =CountandSay.countAndSay(2);
        System.out.println(string);
    }

}
