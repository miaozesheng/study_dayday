package test.thread_test.prodcuer_customer_model;

/**
 * description 来电提醒线程 接电话线程
 *
 * @author miaozesheng 2022/03/19 18:38
 */
public class Phone {

    private boolean flag = false;// 默认手机处于当前等待来电提醒

    public void run(){
        // 需要注意的是,每次调用wait方法,会把锁释放掉,别人可以重新去竞争这个锁

        // 负责来电提醒的线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        synchronized (Phone.this){
                            if(!flag) {
                                System.out.println("有新电话接入,请接听---");
                                Thread.sleep(5000);
                                flag = true;
                                Phone.this.notify();
                                Phone.this.wait();
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // 接电话的线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 不断的接电话
                    while (true) {
                        synchronized (Phone.this) {
                            if (flag) {
                                // 可以接电话了
                                System.out.println("电话接听中-----");
                                flag = false; // 结束后继续等待电话输入
                                // 线程先唤醒别人 再等待自己
                                Phone.this.notify();
                                Phone.this.wait();
                            }else{
                                // 线程先唤醒别人 再等待自己
                                Phone.this.notify();
                                Phone.this.wait();
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        Phone huawei = new Phone();
        huawei.run();
        /*
        有新电话接入,请接听---
        电话接听中-----
        有新电话接入,请接听---
        电话接听中-----
        有新电话接入,请接听---
         */
    }
}
