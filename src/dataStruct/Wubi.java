package dataStruct;

import java.util.Scanner;

/**
 * Created by lhy on 2017/7/6.
 */
public class Wubi {
    public static void main(String args[]){
        Scanner in  = new Scanner(System.in);
        String b =in.next();
        //char[] codeArr = b.toCharArray();
        int res= codeIndex(b);
        System.out.println(res);
    }
    public static int codeIndex(String code){
        int factor[]={1+25*25*25+25*25+25,1+25+25*25,1+25,1};
        char[] a=code.toCharArray();
        int index=0,len=0;
        for(int i=0;i<a.length;i++) {
            index += factor[len++] * (a[i] - 'a');
        }
        return index+(len-1);
    }
}
