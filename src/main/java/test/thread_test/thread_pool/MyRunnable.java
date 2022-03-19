package test.thread_test.thread_pool;

/**
 * description
 *
 * @author miaozesheng 2022/03/19 19:17
 */
public class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+"输出了:helloworld!=======>"+i);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
