package dataStruct;

import java.util.*;
/**
 * Created by lhy on 2017/7/10.
 */
public class FindPrimePair {
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int i = scanner.nextInt();
    System.out.println(findPrimePair(i));
}
//ͨ���������ҵ������������
private static int findPrimePair(int sum) {
    if (sum <= 3) { return 0; }
    int count=0;
    for (int i = 2;i<=sum/2;i++) {
        for (int j = 2 ; j <sum-i+1;j++) {
            if (isPrime(i) && isPrime(j)&& (i+j)==sum)
            { count++;
                System.out.println(sum+"="+i+"+"+j);
            }
        }
    } return count;
}
//�ж���������Ƿ�Ϊ����
private static boolean isPrime(int i) {
    for (double j = 2; j <= Math.sqrt(i); j++) {
        if (i % j == 0)
        { return false; }
    } return true;
}
}
