package test.network.tcp_test.multi2_test;

import test.network.tcp_test.instant_test.ServerDemo;

import java.io.*;
import java.net.Socket;

/**
 * description
 *
 * @author miaozesheng 2022/03/20 18:36
 */
public class ServerReaderThread extends Thread{
    // 接收socket对象
    private Socket socket;
    public ServerReaderThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        // 在run方法里边进行具体的消息处理
        try {
            // 从socket通信管道中得到一个字节输入流
            InputStream inputStream = socket.getInputStream();
            // 字节输入流包装成高级流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String msg ;
            while((msg = bufferedReader.readLine()) != null){
                System.out.println(socket.getRemoteSocketAddress()+"===========>"+msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(socket.getRemoteSocketAddress()+"下线了!!!");
        }
    }

}
