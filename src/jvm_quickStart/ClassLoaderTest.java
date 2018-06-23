package jvm_quickStart;

public class ClassLoaderTest {
    /**
     * Bootstrap Loader（引导类加载器）是用C语言实现的，
     * 找不到一个确定的返回父Loader的方式，于是就返回null。
     * @param args
     */
    public static void main(String[] args) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader);
        System.out.println(loader.getParent());
        System.out.println(loader.getParent().getParent());
    }
}
