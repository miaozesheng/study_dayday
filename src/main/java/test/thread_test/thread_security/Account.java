package test.thread_test.thread_security;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * description
 *
 * @author miaozesheng 2022/03/19 10:54
 */
public class Account {
    private String cardId;
    private Double money;

    public Account() {
    }

    public Account(String cardId, Double money) {
        this.cardId = cardId;
        this.money = money;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    // 原始取钱方法,会出错
    public void drawMoney(Double money){

        // 1.判断谁来取钱
        String name  = Thread.currentThread().getName();
        // 2.判断钱是否够
        if(this.money >= money){
            System.out.println(name+"来取钱了,吐出:"+money);
            this.money -= money;
            System.out.println(name+"取钱后余额为:"+this.money);
        }else{
            System.out.println(name+"余额不足!"+"当前余额为"+this.money);
        }
    }
// 演示几种加锁方式

    // 第一种加锁方式,同步代码块
    public void drawMoneyOne(Double money){

        // 1.判断谁来取钱
        String name  = Thread.currentThread().getName();

        //这里使用随机字符串也能实现锁,但是这个随机字符串会有一个问题
        /**
         * 假设除了小明小红一家人来取钱,还有小白小黑也来取钱,这个时候如果用这个随机字符串作为唯一对象,那么小黑小白也会被拦下来,因为这个唯一对象被其他人占用了
         * 但是理论上,小黑小白取钱和小红小明一家人没有关系,因为你们的账号和别人的账号不是一个账号,但是是一个取钱方法,这时候会影响到其他人
         * 所以这个锁对象不能用这种随机的唯一对象,而是和他们有关系的唯一对象,如他们自己的账户对象,也就是用共享资源作为锁对象(规范)
         *
         * 用共享资源作为锁对象(规范)
         * 实例方式使用this作为锁对象
         * 静态方法,那么使用类名.class作为锁对象
         */
//       这里的this就是当前的账户对象
        synchronized (this) {
            // 2.判断钱是否够
            if(this.money >= money){
                System.out.println(name+"来取钱了,吐出:"+money);
                this.money -= money;
                System.out.println(name+"取钱后余额为:"+this.money);
            }else{
                System.out.println(name+"余额不足!"+"当前余额为"+this.money);
            }
        }
    }

    // 第二种取钱方式 同步方法
    public synchronized void drawMoneyTwo(Double money){
        /**
         * 使用同步方法的底层原理
         * 1.同步方法其实底层也是有隐式锁对象的,只是锁的范围是整个方法代码
         * 2.如果方法是实例方法,同步方法默认用this作为锁对象,但是代码要高度面向对象
         * 3.如果方法是静态方法,同步方法默认用类名.class作为锁对象,
         */

        // 1.判断谁来取钱
        String name  = Thread.currentThread().getName();
        // 2.判断钱是否够
        if(this.money >= money){
            System.out.println(name+"来取钱了,吐出:"+money);
            this.money -= money;
            System.out.println(name+"取钱后余额为:"+this.money);
        }else{
            System.out.println(name+"余额不足!"+"当前余额为"+this.money);
        }
    }
    /**
     * 同步代码块和同步方法那个好一点?
     * 1.同步代码块锁的范围小,效率就会高 同步方法锁的是整个方法,效率低一点
     * 2.实际开发中,同步方法反而使用的多一点 写法方便 比较明了
     */

    // 第三种取钱方式 lock锁
    /**
     * 为了更清晰的表达如何加锁和释放锁,jdk5之后提供了一个新的锁对象lock 更加灵活,方便
     * lock实现提供比使用synchronized方法和语句可以获得更广泛的锁定操作
     * Lock是接口不能实例化,我们使用的他的实现类ReentrantLock来构建锁对象
     */

    // 创建一个锁对象,唯一且不可替换(final)
    private final Lock lock = new ReentrantLock();
    public void drawMoneyThree(Double money){
        // 1.判断谁来取钱
        String name  = Thread.currentThread().getName();
        lock.lock();
        try {
            // 2.判断钱是否够
            if(this.money >= money){
                System.out.println(name+"来取钱了,吐出:"+money);
                this.money -= money;
                System.out.println(name+"取钱后余额为:"+this.money);
            }else{
                System.out.println(name+"余额不足!"+"当前余额为"+this.money);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

}
