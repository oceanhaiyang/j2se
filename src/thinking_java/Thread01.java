package thinking_java;

/**
 * Created by lhy on 2018/6/23.
 */
public class Thread01 extends Thread {
     ThreadLocal tl;
    public Thread01(ThreadLocal tl){
        this.tl=tl;
    }

    @Override
    public void run() {
        System.out.print("thread01的值"+tl.get());
    }
}
