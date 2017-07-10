package com.haiyang.j2se;
import java.util.Scanner;

/**
 * 五笔的字典序列
 * Created by lhy on 2017/7/6.
 */
public class Tencent01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String b = in.next();
        int res = codeindex(b);
        System.out.println(res);
    }
    public static int codeindex(String code) {
        int factor[] = {1+25+25*25+25*25*25, 1+25+25*25, 1+25, 1};//权重数组
        char[] codearr = code.toCharArray();//把字符串转为字符数组
        int index = 0;
        int len = 0;
        for(int i = 0;i < codearr.length; i++){
            index += factor[len++] * (codearr[i] - 'a');//与a的位置对比
        }
        return index + (len - 1);
    }

    }

