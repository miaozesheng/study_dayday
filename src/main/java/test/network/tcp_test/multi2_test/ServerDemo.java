package test.network.tcp_test.multi2_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * description tcp服务端开发,多发多收 这里面要求实现一个服务端可以接受多个客户端的消息
 *  实现方式就是之前用来接受消息的main线程,我这这里不用来接受消息,而是用来将消息给到子线程去处理
 *
 * @author miaozesheng 2022/03/20 18:12
 */
public class ServerDemo {
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

                // 开启独立线程进行socket处理
                new ServerReaderThread(socket).start();


            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
