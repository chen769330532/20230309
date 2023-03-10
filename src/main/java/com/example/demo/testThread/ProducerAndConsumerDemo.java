package com.example.demo.testThread;

import java.util.Scanner;

public class ProducerAndConsumerDemo {
    // 实例化一个果篮，用于存放苹果
    private static FruitBasket fruitBasket = new FruitBasket(0);
    // 实例化一个输入实例，用于获取控制台输入
    private static Scanner scanner = new Scanner(System.in);

    /**
     * 测试入口
     * 
     * @param args
     */
    public static void main(String[] args) {
        // 实例化一个生产者
        Thread producer = new Thread(new Producer(fruitBasket, scanner));
        producer.start();// 启动生产者

        // 实例化一个消费者A
        Thread consumerA = new Thread(new Consumer(fruitBasket, 3, "consumerA"));
        consumerA.start();// 启动消费者A

        // 实例化一个消费者B
        Thread consumerB = new Thread(new Consumer(fruitBasket, 2, "consumerB"));
        consumerB.start();// 启动消费者B

        // 实例化一个消费者C
        Thread consumerC = new Thread(new Consumer(fruitBasket, 4, "consumerC"));
        consumerC.start();// 启动消费者C
    }
}