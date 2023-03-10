package com.example.demo.testThread;

public class Consumer implements Runnable {

    private FruitBasket fruitBasket;// 定义一个果篮，用于存放苹果数
    private long seconds;// 定义吃苹果时间
    private String name;// 消费者名

    /**
     * 根据果篮，休眠时间，名字来初始化一个消费者。
     * 
     * @param fruitBasket
     *            果篮
     * @param seconds
     *            吃苹果时间
     * @param name
     *            消费者名
     */
    public Consumer(FruitBasket fruitBasket, long seconds, String name) {
        this.fruitBasket = fruitBasket;
        this.seconds = seconds;
        this.name = name;
    }

    /**
     * 重写方法，用于实现消费者拿苹果的逻辑。
     */
    @Override
    public void run() {
        while (true) {// 循环执行
            // 以果篮实例为同步锁，每次只允许一个生产者或者消费者线程进行操作。
            synchronized (fruitBasket) {
                // 如果果篮中苹果数为0,
                if (fruitBasket.getAppleNumber() == 0) {
                    try {
                        // 通知生产者放置苹果。
                        fruitBasket.notifyAll();
                        fruitBasket.wait();// 消费者进行等待
                    } catch (InterruptedException e) {
                        System.out.println("系统错误");
                    }
                } else {// 如果果篮中苹果数大于0
                    System.out.println("\n========================================================");
                    System.out.println("当前果篮中苹果数为：  " + fruitBasket.getAppleNumber());
                    System.out.println(name + " 开始拿苹果");
                    fruitBasket.decreaseNumber();// 果篮中苹果数减1
                    System.out.println(name + " 拿完苹果，当前果篮中苹果数为：  " + fruitBasket.getAppleNumber());
                    try {
                        System.out.println(name + " 开始吃苹果……");
                        long start = System.currentTimeMillis();
                        Thread.sleep(seconds * 1000);// 吃苹果的时间
                        long end = System.currentTimeMillis();
                        System.out.println(name + " 吃完苹果了：  " + (end - start));
                        fruitBasket.notifyAll();// 唤醒生产者和消费者
                        fruitBasket.wait();// 当前消费者等待
                    } catch (InterruptedException e) {
                        System.out.println("系统错误");
                    }
                }
                System.out.println();
            }
        }
    }

}