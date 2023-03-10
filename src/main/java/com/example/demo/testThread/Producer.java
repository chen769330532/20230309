package com.example.demo.testThread;

import java.util.Scanner;

public class Producer implements Runnable {

    private FruitBasket fruitBasket;// 定义一个果篮，用于存放苹果数
    private Scanner scanner;// 用于获取控制台输入的数据

    /**
     * 构造方法，用于初始化一个生产者。
     * 
     * @param fruitBasket
     *            果篮类
     * @param scanner
     *            输入类
     */
    public Producer(FruitBasket fruitBasket, Scanner scanner) {
        this.fruitBasket = fruitBasket;
        this.scanner = scanner;
    }

    /**
     * 重写run方法，用于实现生产者放苹果的逻辑。
     */
    @Override
    public void run() {
        while (true) {// 循环执行
            // 以果篮实例为同步锁，每次只允许一个生产者或者消费者线程进行操作。
            synchronized (fruitBasket) {
                System.out.println("\n========================================================");
                System.out.println("当前果篮中苹果数为： " + fruitBasket.getAppleNumber());
                try {
                    System.out.println("生产者向果篮中放置苹果： ");
                    // 获取输入的苹果数
                    int number = Integer.parseInt(scanner.next());
                    // 向果篮中添加苹果
                    fruitBasket.increaseNumber(number);
                    System.out.println("放置苹果完成，当前果篮中苹果数为：  " + fruitBasket.getAppleNumber());

                    // 如果果篮中苹果数大于0，则通知消费者来拿苹果
                    if (fruitBasket.getAppleNumber() > 0) {
                        System.out.println("通知消费者来拿苹果。");
                        fruitBasket.notifyAll();// 通知所有的消费者
                        fruitBasket.wait();// 生产者等待
                    }
                } catch (NumberFormatException e) {
                    System.out.println("输入的数据格式错误，请重新输入。");
                } catch (InterruptedException e) {
                    System.out.println("系统异常");
                }
                System.out.println();
            }
        }
    }

}
