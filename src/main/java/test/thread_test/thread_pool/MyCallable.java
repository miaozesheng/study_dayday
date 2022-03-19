package test.thread_test.thread_pool;

import java.util.concurrent.Callable;

/**
 * description
 *
 * @author miaozesheng 2022/03/19 19:31
 */
public class MyCallable implements Callable<String> {
    private int n ;
    public MyCallable(int n){
        this.n  = n;
    }

    @Override
    public String call() throws Exception {
        // 局部变量必须初始化才能使用 成员变量不用初始化的原因就是java会给赋默认值
        int sum = 0;
        for (int i = 0; i <=n ; i++) {
            sum +=i;
        }
        return Thread.currentThread().getName()+"执行的结果是"+sum;
    }
}
