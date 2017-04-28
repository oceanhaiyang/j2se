package dataStruct;
/**
 * n从一开始，每次操作加倍或加1，当n为2013时最少操作几次?
 * @author haiyang
 *
 */
public class test01 {
	public static void main(String[] args) {
		int i=TestDemo01.count();
		System.out.println("最少操作"+i+"次");
	}
}
class TestDemo01{
	private static int flag=0;
	private static int n=2013;
	public static int count(){
		while(n>1){
			if(n%2==0){
				n=n/2;
				flag++;
			}
			else{
				n--;
				flag++;
			}
		}
		return flag;
	}
}
