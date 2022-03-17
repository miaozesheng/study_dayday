package test.thread_test;

/**
 * description 一些常用线程方法的练习
 *
 * @author miaozesheng 2022/03/17 23:24
 */
public class ThreadMethodDemo {
    public static void main(String[] args) {
        // Thread.currentThread()获取当前执行线程的基本信息 如名称

        testOne();
    }


    public static void testOne(){
        MyThread t1 = new MyThread("11");
        //t1.setName("线程11111");
        t1.start();

        MyThread t2 = new MyThread("22");
        //t2.setName("线程22222");
        t2.start();
    }
    public static void testMethod() throws Exception {
        MyThread t1 = new MyThread("11");
        //t1.setName("线程11111");
        t1.start();
        Thread.currentThread().getName();
        Thread.sleep(1000);
        Thread.yield();
    }
}

class MyThread extends Thread{
    // 增加一个有参构造器,将名称送给父类构造器,可以直接给这个线程设置名字,免去了我们写t2.setName("线程22222");的方法
    public MyThread(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("子线程输出"+Thread.currentThread().getName());
        }
    }
}