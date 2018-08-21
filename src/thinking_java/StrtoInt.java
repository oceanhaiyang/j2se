package thinking_java;

/**
 * Created by lhy on 2018/7/13.
 */


public class StrtoInt {
      public  int convert(String str) {
        if(str==null || str.length() == 0){
            return 0;
        }
        int n = str.length(), s = 1;
        char[] chs = str.toCharArray();
        int res = 0;
        if(chs[0] == '-') s = -1;
        for(int i = (chs[0] ==  '-' || chs[0] == '+') ? 1 : 0; i < n; ++i){
            if(!('0' <= chs[i] && chs[i] <= '9')) return 0;
            res = (res << 1) + (res << 3) + (chs[i] & 0xf);//res=res*10+str[i]-'0';
        }
        return (int)res * s;
    }
      /*public int convert(String str) {
          if(str==null || str.length() == 0){
              return 0;
          }
          int result = 0;
          char[] chs = str.toCharArray();
          int len = chs.length;
          for(int i=len-1, j=0; i>0; i--, j++){
              int c = (int)chs[i];
              if(c<48 ||c>57){
                  return 0;
              }else{
                  result += (c-48)*Math.pow(10, j);
              }
          }
          int c = (int)chs[0];
          if(c<=57&&c>=48){
              result += (c-48)*Math.pow(10, len-1);
          }
          if(result<-2147483648 || result>2147483647){
              return 0;     //越界，如果真的越界，直接会报错，result本身没办法越界
          }else if(str.equals("2147483648")){
              if(c == 45){
                  result = -2147483648;     //边界值
              }
          }else if(str.equals("-2147483648")){
              result = -2147483648;         //边界值
          }else{
              if(c == 45){
                  result = -result;         //负号处理
              }
          }
          return result;
      }*/
    public static void main(String[] args){
          StrtoInt strtoInt = new StrtoInt();
          int aa = strtoInt.convert("-123");
        System.out.println(aa);
    }
}
