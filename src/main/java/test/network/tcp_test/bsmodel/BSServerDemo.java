package test.network.tcp_test.bsmodel;


import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * description 实现bs模型
 *
 * @author miaozesheng 2022/03/20 20:07
 */
public class BSServerDemo {
    private static ExecutorService pool = new ThreadPoolExecutor(3,5,6, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(2),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {

        try {
            // 1.注册端口
            ServerSocket ss = new ServerSocket(8080);
            // 2.创建一个循环接口多个客户端的请求
            while(true){
                Socket socket = ss.accept();
//                new ServerReaderThread(socket).start(); 我们使用线程池实现,这里就不需要这个线程去跑了
                pool.execute(new BSRunnable(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class ServerReaderThread extends Thread{
    private Socket socket;

    public ServerReaderThread(Socket socket){
        this.socket = socket;
    }


    @Override
    public void run() {
        try {
            //浏览器,已经与本线程建立了Socket管道
            // 响应消息给浏览器显示
            PrintStream ps = new PrintStream(socket.getOutputStream());
            // 必须响应http协议格式数据,不然浏览器不认识
            ps.println("HTTP/1.1 200 OK");
            ps.println("Content-Type:text/html;charset=UTF-8");
            ps.println();//必须发送一个开航 才可以响应数据回去给浏览器
            ps.println("<span style='color:red;font-size=90px'>我们返回的数据在这里了!!!!!!!!</span>");
            ps.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
