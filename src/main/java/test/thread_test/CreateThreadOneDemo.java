package test.thread_test;

/**
 * description 继承Thread类实现
 * 优点: 编码简单
 * 缺点: 只能继承一个类,不利于扩展
 *
 * @author miaozesheng 2022/03/17 22:37
 */
public class CreateThreadOneDemo {
    public static void main(String[] args) {
        ThreadOne t1 = new ThreadOne();
        t1.start();
        //调用start启用线程,但是实际执行的是run方法
        // 这里我们要注意,如果我们直接调用run方法,那么会把run方法当成一个普通方法去跑,多线程是没有用到的,当时相当于单线程执行
        for (int i = 0; i < 1000; i++) {
            System.out.println("main线程也在执行了!!!");
        }
        /*
        两个线程交替执行

        线程创建方式1执行了!!
        线程创建方式1执行了!!
        main线程也在执行了!!!
        main线程也在执行了!!!
        main线程也在执行了!!!
        main线程也在执行了!!!
        线程创建方式1执行了!!
        线程创建方式1执行了!!
        线程创建方式1执行了!!
        main线程也在执行了!!!
        main线程也在执行了!!!
        main线程也在执行了!!!
         */
    }
}

// 这里的ThreadOne只是一个线程类,不是线程对象,如果要调用里边的方法,我们要new一个线程对象出来,再去做操作
class ThreadOne extends Thread{
    // run方法里边定义线程要干啥
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println("线程创建方式1执行了!!");
        }
    }
}
