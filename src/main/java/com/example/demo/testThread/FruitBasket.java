package com.example.demo.testThread;

public class FruitBasket {
    private int appleNumber;// 果篮中苹果数

    /**
     * 构造方法，根据指定苹果数初始化果篮。
     * 
     * @param appleNumber
     *            苹果数
     */
    public FruitBasket(int appleNumber) {
        this.appleNumber = appleNumber;
    }

    /**
     * 同步方法，由于修饰的是非静态方法，所以锁对象为果篮类的实例。 获得果篮中的苹果数
     * 
     * @return 苹果数
     */
    public synchronized int getAppleNumber() {
        return appleNumber;
    }

    /**
     * 同步方法，由于修饰的是非静态方法，所以锁对象为果篮类的实例。 设置果篮中的苹果数
     * 
     * @param appleNumber
     *            苹果数
     */
    public synchronized void setAppleNumber(int appleNumber) {
        this.appleNumber = appleNumber;
    }

    /**
     * 同步方法，由于修饰的是非静态方法，所以锁对象为果篮类的实例。 消费者每次从果篮中拿一个苹果，果篮中苹果数每次减1。
     * 
     */
    public synchronized void decreaseNumber() {
        appleNumber--;
    }

    /**
     * 同步方法，由于修饰的是非静态方法，所以锁对象为果篮类的实例。生产者每次放置一定的苹果数，果篮中苹果数每次增加一定数量。
     * 
     * @param number
     *            苹果数
     */
    public synchronized void increaseNumber(int number) {
        appleNumber += number;
    }
}