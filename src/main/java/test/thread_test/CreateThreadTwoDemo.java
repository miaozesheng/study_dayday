package test.thread_test;

import java.util.concurrent.Callable;

/**
 * description 实现Callable接口的方式
 * 1.定义一个线程任务类,实现Runnable接口,重写run方法
 * 2.创建线程任务类的对象
 * 3.把线程任务类的对象交给Thread去处理
 * 4.Thread调用线程的start方法启动线程
 *
 * 优点: 实现了runnable接口,可以继续继承类和实现其他接口,扩展性强
 * 缺点: 多了一层包装对象,而且线程执行结果不可以返回
 *
 * @author miaozesheng 2022/03/17 22:47
 */
public class CreateThreadTwoDemo {
    public static void main(String[] args) {
       testTwo();
    }
    public static void testOne(){
        ThreadTwo t2  = new ThreadTwo();
        Thread t = new Thread(t2);
        t.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("main线程执行了@@@@");
        }
        /*
        线程交替执行

        线程创建第二种方式
        线程创建第二种方式
        main线程执行了@@@@
        main线程执行了@@@@
        main线程执行了@@@@
         */
    }

    // 使用匿名内部类的方式实现多线程
    public static void testTwo(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("11111");
                }
            }
        });
        thread.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("22222");
                }
            }
        }).start();

        new Thread(()-> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("3333");
            }
        }).start();
    }

}

class ThreadTwo implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程创建第二种方式");
        }
    }
}