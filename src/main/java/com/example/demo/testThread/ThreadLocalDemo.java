package com.example.demo.testThread;

public class ThreadLocalDemo {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
    private static ThreadLocal<Double> threadLocal2 = new InheritableThreadLocal<Double>();

    public static void main(String[] args) {
        /**
         * 测试ThreadLocal的get，set方法
         */
        // 设置main线程的名字为MainDemo
        Thread.currentThread().setName("MainDemo");
        // 参数为Integer型，所以初始值为null，所以输出MainDemo-->null
        System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
        // 设置main线程保存的值为2
        threadLocal.set(2);
        // 设置值为2，所以输出MainDemo-->2
        System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());

        /**
         * 此行代码用于测试构造方法与run方法是由哪个线程调用
         */
        new Thread(new ThreadDemo(), "ThreadDemo").start();

        /**
         * 测试ThreadLocal，InheritableThreadLocal的区别
         */
        // 设置main线程保存的值为100
        threadLocal.set(100);
        // 设置值为100，所以输出MainDemo-->100
        System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
        // 启动一个线程ThreadLocalDemo
        new Thread(() -> {
            // ThreadLocal会重新创造一个变量副本，所以输出ThreadLocalDemo-->null
            System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
            threadLocal.set(50);
            new Thread(() -> {
                // ThreadLocal会重新创造一个变量副本，所以输出ThreadLocalDemo1-->null
                System.out.println(Thread.currentThread().getName() + "-->" + threadLocal2.get());
            }, "ThreadLocalDemo1").start();
        }, "ThreadLocalDemo").start();

        // 设置main线程值为100.0
        threadLocal2.set(100.0);
        // 设置值为100.0，所以输出MainDemo-->100.0
        System.out.println(Thread.currentThread().getName() + "-->" + threadLocal2.get());
        // 启动一个线程InheritableThreadLocalDemo
        new Thread(() -> {
            // 其会拷贝上一个线程的值，上一个线程为main线程，所以输出为InheritableThreadLocalDemo-->100.0
            System.out.println(Thread.currentThread().getName() + "-->" + threadLocal2.get());
            threadLocal2.set(50.0);
            new Thread(() -> {
                // 其会拷贝上一个线程的值，上一个线程为InheritableThreadLocalDemo线程，所以输出为InheritableThreadLocalDemo-->50.0
                System.out.println(Thread.currentThread().getName() + "-->" + threadLocal2.get());
            }, "InheritableThreadLocalDemo1").start();
        }, "InheritableThreadLocalDemo").start();
    }

    public static class ThreadDemo implements Runnable {
        public ThreadDemo() {
            // 初始化时，由main线程调用，所以输出MainDemo-->2
            System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
        }

        @Override
        public void run() {
            // 运行时，由当前线程调用，会重新创建一个变量副本，所以输出ThreadDemo-->null
            System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
        }
    }
}