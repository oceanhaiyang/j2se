/**
 * 
 */

package dataStruct;
import java.util.ArrayList;
public class josephus {
    public static void main(String[] args) {
    	int n = 9, k = 1, m = 5 ;
    	ArrayList<Integer> list=new ArrayList<>(n);
    	//初始化一些数据
	    for(int i=1;i<=n;i++){
	    list.add(i);
	    }
	    int i=k-1,t=1; //初始化下标和计数器
	    	while(!list.isEmpty()){
	    		if(t==m){          
	    			System.out.print(list.remove(i)+"  ");
	    				i--;//删除过后，i的下标已经变化了，所以需要减少
	    				t=0;//记数器重新归零
	    		}
	    		t++;i++;//往下加
	    		if(i>=list.size()){//如果到末尾了，就直接跳到开始位置
	    			i=0;
	    		}
	    	}
    }
}
