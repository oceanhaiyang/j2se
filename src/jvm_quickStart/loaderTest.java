package jvm_quickStart;

/**
 * Class.forName()和ClassLoader.loadClass()区别

1. Class.forName()：将类的.class文件加载到jvm中之外，还会对类进行解释，
 执行类中的static块；

2.ClassLoader.loadClass()：只干一件事情，就是将.class文件加载到jvm中，
 不会执行static中的内容,只有在newInstance才会去执行static块。

3.Class.forName(name, initialize, loader)带参函数也可控制是否加载static块。
 并且只有调用了newInstance()方法采用调用构造函数，创建类的对象 。
 *
 */
public class loaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader);
        //使用ClassLoader.loadClass()来加载类，不会执行初始化块
        loader.loadClass("jvm_quickStart.Test2");
        //使用Class.forName()来加载类，默认会执行初始化块
        //Class.forName("jvm_quickStart.Test2");
        //使用Class.forName()来加载类，并指定ClassLoader，初始化时不执行静态块
        //Class.forName("Test2", false, loader);
    }
}
 class Test2 {
    static {
        System.out.println("静态初始化块执行了！");
    }
}