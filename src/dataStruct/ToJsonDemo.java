package dataStruct;

import java.math.BigDecimal;

/**
 * 去掉json串的",",string类型用BigDecimal计算
 */
public class ToJsonDemo {
    public static void main(String[] args){
        String result = "{\n" +
                "\t\"status\": \"1\",\n" +
                "\t\n" +
                "}";
        if (result.lastIndexOf(",") == -1) {
            System.out.print(result);
        }

        String a = result.substring(result.lastIndexOf(",")+1);

        String b = result.substring(0, result.lastIndexOf(","));
        String c = b.concat(a);


        BigDecimal b1 = new BigDecimal("8.63");
        BigDecimal b2 = new BigDecimal(10000);
        Double value = b1.multiply(b2).doubleValue();

        String m = (String.valueOf(value));


        System.out.print( result.substring(0, result.lastIndexOf(",")).concat(result.substring(result.lastIndexOf(",") + 1)));

    }
}
