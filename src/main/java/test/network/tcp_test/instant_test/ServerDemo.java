package test.network.tcp_test.instant_test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * description 即时通信
 *
 * @author miaozesheng 2022/03/20 18:12
 */
public class ServerDemo {

    // 把当前全部在线的socket管道存储起来
    public static List<Socket> allOnLineSockets = new ArrayList<>();

    public static void main(String[] args) {

        try {
            System.out.println("=====tcp服务端启动====");
            // 服务端的socket对象创建
            ServerSocket serverSocket = new ServerSocket(6666);
            // 定义一个死循环 主线程不断接收客户端的socket连接管道
            while (true) {
                // 用accept方法,等待接受客户端的Socket请求连接,建立socket通信管道
                Socket socket = serverSocket.accept();
                System.out.println(socket.getRemoteSocketAddress()+"同学上线了!!!");
                allOnLineSockets.add(socket);

                // 开启独立线程进行socket处理
                new ServerReaderThread(socket).start();


            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
class ServerReaderThread extends Thread{
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
                // 把这个消息进行端口转发给全部客户端socket
                sendMessageToAll(msg);
            }
        } catch (Exception e) {
            System.out.println(socket.getRemoteSocketAddress()+"下线了!!!");
            ServerDemo.allOnLineSockets.remove(socket);
        }
    }

    private void sendMessageToAll(String msg) throws Exception{
        for (Socket socket : ServerDemo.allOnLineSockets) {
            PrintStream ps = new PrintStream(socket.getOutputStream());
            ps.println(msg);
            ps.flush();
        }
    }
}