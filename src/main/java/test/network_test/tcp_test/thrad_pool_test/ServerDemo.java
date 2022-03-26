package test.network_test.tcp_test.thrad_pool_test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * description tcp服务端开发,多发多收 这里面要求实现一个服务端可以接受多个客户端的消息
 *  实现方式就是之前用来接受消息的main线程,我这这里不用来接受消息,而是用来将消息给到子线程去处理
 *
 *  这种方式实现了一个服务端可以接受多个客户端消息的问题,但是如果有一千万个请求,我们就会创建一千万的线程去处理
 *  这种情况下是有很大问题,所以引入线程池来管理线程处理任务
 *
 * @author miaozesheng 2022/03/20 18:12
 */
public class ServerDemo {
    // 定义一个线程池
    private static ExecutorService pool = new ThreadPoolExecutor(3,5,6, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {

        try {
            System.out.println("=====tcp服务端启动====");
            // 服务端的socket对象创建
            ServerSocket serverSocket = new ServerSocket(7777);


            // 定义一个死循环 主线程不断接收客户端的socket连接管道
            while (true) {
                // 用accept方法,等待接受客户端的Socket请求连接,建立socket通信管道
                Socket socket = serverSocket.accept();
                System.out.println(socket.getRemoteSocketAddress()+"同学上线了!!!");

                // 将任务交给线程池去处理
                Runnable runnable = new ServerRunnable(socket);
                pool.execute(runnable);


            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
