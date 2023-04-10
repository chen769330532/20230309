package com.example.demo.morethread;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.List;
import java.util.concurrent.*;

/**
 * @author Chenjl
 * @date 2023/4/10 10:06
 */
public class Test {

    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().build();

    public static final ThreadPoolExecutor SAFE_POOL = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors()*2,
            Runtime.getRuntime().availableProcessors()*8,
            10L,
            TimeUnit.MINUTES,
            new LinkedBlockingDeque<>(2048),
            namedThreadFactory, new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) {

        List<CompletableFuture<Long>> futures = Lists.newArrayList();
        CompletableFuture<Long> thread1 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("线程1开始执行逻辑等待4秒");
                Thread.sleep(4000);
                System.out.println("线程1结束执行逻辑等待4秒");
                return 4L;
            } catch (Exception e) {
                return 4L;
            }
        }, SAFE_POOL);
        futures.add(thread1);

        CompletableFuture<Long> thread2 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("线程2开始执行逻辑等待12秒");
                Thread.sleep(12000);
                System.out.println("线程2结束执行逻辑等待12秒");
                return 12L;
            } catch (Exception e) {
                return 12L;
            }
        }, SAFE_POOL);
        futures.add(thread2);

        CompletableFuture<Long> thread3 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("线程3开始执行逻辑等待8秒");
                Thread.sleep(8000);
                System.out.println("线程3结束执行逻辑等待8秒");
                return 8L;
            } catch (Exception e) {
                return 8L;
            }
        }, SAFE_POOL);
        futures.add(thread3);

        CompletableFuture<Void> all = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        all.join();

        futures.forEach(item->{
            System.out.println(item.join());
        });

        System.out.println("#############等待上面的内容处理好才会输出############");

        SAFE_POOL.shutdown();
    }
}
