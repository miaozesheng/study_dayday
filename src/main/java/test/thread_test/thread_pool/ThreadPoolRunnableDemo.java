package test.thread_test.thread_pool;

import java.util.concurrent.*;

/**
 * description 线程池的demo1
 *
 * @author miaozesheng 2022/03/19 19:02
 */
public class ThreadPoolRunnableDemo {
    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(3, 5, 6, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        Runnable target = new MyRunnable();
        // 三个核心线程
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);

        // 五个在等待队列里边
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);

        // 多出来两个,这时候就会创建临时线程
        pool.execute(target);
        pool.execute(target);

        // 执行拒绝策略   Task test.thread_test.thread_pool.MyRunnable@7adf9f5f rejected from java.util.concurrent.ThreadPoolExecutor
        pool.execute(target);
        pool.execute(target);

        // 关闭线程池 实际开发中不会使用关闭线程池的方法
        pool.shutdownNow(); // 立即关闭,即使任务没有完成 丢失任务
        pool.shutdown();// 关闭 等待任务完成后 进行关闭 不会丢失任务
    }

}
