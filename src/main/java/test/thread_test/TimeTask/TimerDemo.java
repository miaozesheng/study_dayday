package test.thread_test.TimeTask;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * description timer定时器的使用和了解
 *
 * @author miaozesheng 2022/03/19 20:12
 */
public class TimerDemo {
    public static void main(String[] args) {
        Timer timer = new Timer();
        // 第一个参数是定时器任务要做的操作 第二个参数是延时调用的时间 第三个参数是调用周期
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"执行a一次!!!"+new Date());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },3,2000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"执行b一次!!!"+new Date());
                int x = 10/0;
            }
        },0,2000);
    }
}
