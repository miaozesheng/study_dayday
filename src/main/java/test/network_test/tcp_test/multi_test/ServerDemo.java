package test.network_test.tcp_test.multi_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * description tcp服务端开发,多发多收
 *
 * @author miaozesheng 2022/03/20 18:12
 */
public class ServerDemo {
    public static void main(String[] args) {

        try {
            System.out.println("=====tcp服务端启动====");
            // 服务端的socket对象创建
            ServerSocket serverSocket = new ServerSocket(7777);
            // 用accept方法,等待接受客户端的Socket请求连接,建立socket通信管道
            Socket socket = serverSocket.accept();
            // 从socket通信管道中得到一个字节输入流
            InputStream inputStream = socket.getInputStream();
            // 字节输入流包装成高级流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String msg ;
            while((msg = bufferedReader.readLine()) != null){
                System.out.println(socket.getRemoteSocketAddress()+"===========>"+msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
