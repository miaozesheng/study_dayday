package test.thread_test.thread_security;

/**
 * description 取钱的线程类
 *
 * @author miaozesheng 2022/03/19 10:57
 */
public class DrawThread extends Thread {

    private Account account;

    // 为该线程类接受账户对象做准备,写一个有参构造器,来接受账户对象
    public DrawThread(Account account,String name){
        // 这里想给这个线程起名字,要调用父类的构造器
        super(name);
        this.account = account;
    }

    @Override
    public void run() {
        //取钱
        //account.drawMoney(100000.00);
        //account.drawMoneyOne(100000.00);
       // account.drawMoneyTwo(100000.00);
        account.drawMoneyThree(100000.00);
    }

}
