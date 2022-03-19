package test.thread_test.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * description 使用工具类创建线程池 其实executors的底层也是基于线程池的实现类ThradPoolExecutor创建线程对象的
 *
 *  // 创建一个线程池,线程数据随着任务的增加而增加,如果线程任务执行完毕且空闲了一段时间则会被回收掉
 *         Executors.newCachedThreadPool();
 *         // 创建一个固定线程数量的线程池,如果某个线程因为执行异常而结束,那么线程会补充一个新的线程替代它
 *         Executors.newFixedThreadPool(5);
 *         // 创建只有一个线程的线程池对象,如果该线程出现异常而结束,那么线程池会补充一个新线程
 *         Executors.newSingleThreadExecutor();
 *         // 创建一个线程池,可以实现在给定的延迟后运行任务,或者定期执行任务
 *         Executors.newScheduledThreadPool(5);
 *
 *
 *
 * 存在的问题:在大型并发系统环境中,可能会存在系统风险
 * newFixedThreadPool
 * newSingleThreadExecutor
 * 上述两个线程池任务队列允许的长度是Integer.MAX_VALUE,可能出现oom
 *
 *
 * newCachedThreadPool
 * newScheduledThreadPool
 * 上述两个线程池创建的线程数量最大上限是Integer.MAX_VALUE,线程数随着任务数1:1增长,也可能出现oom
 * @author miaozesheng 2022/03/19 19:48
 */
public class ThreadPoolExecutorsDemo {
    public static void main(String[] args) {

        // 创建一个固定线程数量的线程池,如果某个线程因为执行异常而结束,那么线程会补充一个新的线程替代它
        ExecutorService pool = Executors.newFixedThreadPool(3);
        pool.execute(new MyRunnable());
        pool.execute(new MyRunnable());
        pool.execute(new MyRunnable());
        // 固定只有三个,第四个执行的时候已经没有多余线程了
        pool.execute(new MyRunnable());
    }
}
