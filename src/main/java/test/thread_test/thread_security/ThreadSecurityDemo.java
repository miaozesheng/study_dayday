package test.thread_test.thread_security;

/**
 * description 模拟一个场景,就是两个人同时去取钱,有一个共同的账户,账户余额是十万元,模拟两个人同时取钱十万的场景
 *
 * 1.提供一个账户类,创建一个账户代表两个人的共享账户
 * 2.定义一个线程类,线程类可以处理账户对象
 * 3.创建两个线程对象,传入同一个账户对象
 * 4.启动线程,去同一个账户对象中取钱
 *
 * 线程问题出现的原因:
 *  多个线程同时访问同一个共享资源并且修改该共享资源
 *
 * 解决办法:线程同步
 * 1.同步代码块 把核心代码上锁
 * 2.同步方法
 * 核心思想: 把共享资源加上锁,每次只能一个线程进入访问完毕之后解锁,然后其他线程进来
 * @author miaozesheng 2022/03/19 10:54
 */
public class ThreadSecurityDemo {
    public static void main(String[] args) {
        Account account = new Account("123456",100000.00);
        new DrawThread(account,"小明").start();
        new DrawThread(account,"小红").start();

        Account account2 = new Account("345678",100000.00);
        new DrawThread(account2,"小白").start();
        new DrawThread(account2,"小黑").start();
    }
}
