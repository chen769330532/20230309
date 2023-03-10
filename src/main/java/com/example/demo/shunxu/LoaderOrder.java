package com.example.demo.shunxu;

public class LoaderOrder {

    public static void main(String[] args) {
        staticFunction();
    }

    // 静态变量（有实例化的过程,这就是本题的重点）
    static LoaderOrder st = new LoaderOrder();
    static {
        //System.out.println(b); // 编译报错：因为b在构造代码块后边，此处不能引用。因此Java代码是从上到下的顺序
        System.out.println("1");
    }
    {
        System.out.println("2");
    }
    LoaderOrder() {
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }
    public static void staticFunction() {
        System.out.println("4");
    }

    // 这两个变量写在最后面
    int a = 110;
    static int b = 112;
}
