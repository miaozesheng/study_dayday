package test.thread_test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * description 使用Callable FutureTask实现多线程
 * 1.定义任务类实现Callable接口,重写call方法,并且封装要做的事情到call方法中
 * 2.用FutureTask把实现Callable接口的任务对象封装成线程任务对象
 * 3.把线程任务对象交给Thread处理
 * 4.调用Thread的start方法启动线程,执行任务
 * 5.线程执行完毕后,通过FutureTask的get方法获取任务执行的结果
 *
 *优点: 可以得到结果,可以继承类,可是实现接口,扩展性强
 * 缺点:代码较为复杂
 *
 * @author miaozesheng 2022/03/17 22:55
 */
public class CreateThreadThreeDemo {
    public static void main(String[] args) throws Exception{
        testOne();

    }


    public static void testOne()  {
        Callable<String> callable = new ThreadThree(100);
        // futureTask可以在线程执行完成之后,返回结果
        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread t3_1 = new Thread(futureTask);
        t3_1.start();

        Callable<String> callable2 = new ThreadThree(200);
        // futureTask可以在线程执行完成之后,返回结果
        FutureTask<String> futureTask2 = new FutureTask<>(callable2);
        Thread t3_2 = new Thread(futureTask2);
        t3_2.start();

        try {
            //这里我们需要注意的是 futureTask会返回线程执行的结果,如果该线程没有执行结束,这里的代码会等线程执行完成之后才会执行
            String result1 = futureTask.get();
            System.out.println(result1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        try {
            String result2 = futureTask2.get();
            System.out.println(result2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}

class ThreadThree implements Callable<String> {
    private int n ;
    public ThreadThree(int n){
        this.n = n;
    }
    @Override
    public String call() throws Exception {
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            sum += i;
        }
        return "结果为!!!====>"+sum;
    }
}
