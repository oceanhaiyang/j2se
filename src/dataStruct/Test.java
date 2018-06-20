package dataStruct;

import java.io.*;
import java.util.*;

public class Test {

    public static void main(String[] args) {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null; //用于包装InputStreamReader,提高处理性能。因为BufferedReader有缓冲的，而InputStreamReader没有。
        try {
            String str = "";
            String str1 = "";
            fis = new FileInputStream("d:\\aaa.txt");// FileInputStream
            // 从文件系统中的某个文件中获取字节
            isr = new InputStreamReader(fis);// InputStreamReader 是字节流通向字符流的桥梁,
            br = new BufferedReader(isr);// 从字符输入流中读取文件中的内容,封装了一个new InputStreamReader的对象

            List<List<Integer>> lists = new ArrayList<>();

            while ((str = br.readLine()) != null) {
                //str1 = str + "\n";
                List<Integer> a = new ArrayList<Integer>();
                Scanner sca=new Scanner(str.trim());
                while(sca.hasNextInt()){
                    a.add(sca.nextInt());
                }
                lists.add(a);

            }

            System.out.println("--------------");

            Map map = new HashMap();

            for (Object temp : lists) {
                Object count = map.get(temp);
                map.put(temp, (count == null) ? 1 : (Integer) count + 1);
            }

            /*try {

                File writename = new File("ppp.txt");
                BufferedWriter out;

                out = new BufferedWriter(new FileWriter(writename));

                out.write("无重复的数据:"+"\n");
                for (Object key : map.keySet()) {
                    if (map.get(key).equals(1)) {
                        out.write(key.toString()+"\n");
                    }
                }
                out.write("\n");
                out.write("重复的数据:"+"\n");
                for (Object key : map.keySet()) {
                    if (!map.get(key).equals(1)) {
                        out.write(key + ":" + map.get(key)+"\n");
                    }
                }
                out.flush();
                out.close();

            } catch (IOException e) {
                e.printStackTrace();

            }*/

            System.out.println("无重复的数据");
        for (Object key : map.keySet()) {
            if (map.get(key).equals(1)) {
                System.out.println(key);
            }
        }

        System.out.println("重复的数据");
        for (Object key : map.keySet()) {
            if (!map.get(key).equals(1)) {
                System.out.println(key + ":" + map.get(key));
            }
        }

        } catch (FileNotFoundException e) {
            System.out.println("找不到指定文件");
        } catch (IOException e) {
            System.out.println("读取文件失败");
        } finally {
            try {
                br.close();
                isr.close();
                fis.close();
                // 关闭的时候最好按照先后顺序关闭最后开的先关闭所以先关s,再关n,最后关m
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
