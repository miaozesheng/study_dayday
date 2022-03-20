package test.thread_test.thread_pool;

import java.util.concurrent.*;

/**
 * description 线程池的demo2
 *
 * @author miaozesheng 2022/03/19 19:14
 */
public class ThreadPoolCallableDemo {
    public static void main(String[] args) throws Exception{
        ExecutorService pool = new ThreadPoolExecutor(3,5,5, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        // 核心线程处理
        Future<String> f1 = pool.submit(new MyCallable(1));
        System.out.println(f1.get());
        Future<String> f2 = pool.submit(new MyCallable(2));
        System.out.println(f2.get());
        Future<String> f3 = pool.submit(new MyCallable(3));
        System.out.println(f3.get());
        // 队列等待
        Future<String> f4 = pool.submit(new MyCallable(4));
        System.out.println(f4.get());
        Future<String> f5 = pool.submit(new MyCallable(5));
        System.out.println(f5.get());
        Future<String> f6 = pool.submit(new MyCallable(6));
        System.out.println(f6.get());
        Future<String> f7 = pool.submit(new MyCallable(7));
        System.out.println(f7.get());
        Future<String> f8= pool.submit(new MyCallable(8));
        System.out.println(f8.get());
        // 临时线程创建
        Future<String> f9 = pool.submit(new MyCallable(9));
        System.out.println(f9.get());
        Future<String> f10 = pool.submit(new MyCallable(10));
        System.out.println(f10.get());
        // 拒绝策略
        //Future<String> f11 = pool.submit(new MyCallable(50));
        //System.out.println(f2.get());

    }
}
